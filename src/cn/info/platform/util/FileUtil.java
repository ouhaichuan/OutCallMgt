package cn.info.platform.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * �ļ�����
 * 
 * @author HCOU
 * 
 */
public class FileUtil {
	public List<String> fileNameList = new ArrayList<String>();

	/**
	 * �ϴ��ļ�
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public String uploadFile(HttpServletRequest request,
			HttpServletResponse response) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "uploads\\";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String ymd = sdf.format(new Date());
		ctxPath += ymd + "/";
		// �����ļ���
		File file = new File(ctxPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String fileName = null;
		String result = null;
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			// �ϴ��ļ���
			MultipartFile mf = entity.getValue();
			fileName = mf.getOriginalFilename();

			File uploadFile = new File(ctxPath + fileName);
			try {
				FileCopyUtils.copy(mf.getBytes(), uploadFile);// �����ļ�
				fileNameList.add(ctxPath + fileName);// �����ļ���ϸ·��
				result = "����ɹ�";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * ����Excel
	 * 
	 * @param fileName
	 * @return
	 */
	public ArrayList<ArrayList<String>> readExcel(String fileName) {
		ArrayList<ArrayList<String>> Row = new ArrayList<ArrayList<String>>();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileName);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			Workbook workBook = null;
			try {
				workBook = new XSSFWorkbook(fis);
			} catch (Exception ex) {
				workBook = new HSSFWorkbook(fis);
			}
			// ѭ����Sheet
			for (int numSheet = 0; numSheet < workBook.getNumberOfSheets(); numSheet++) {
				Sheet sheet = workBook.getSheetAt(numSheet);
				if (sheet == null) {
					continue;
				}
				// ѭ����Row
				for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
					Row row = sheet.getRow(rowNum);
					if (row == null) {
						continue;
					}
					// ѭ����Cell
					ArrayList<String> arrCell = new ArrayList<String>();
					for (int cellNum = 0; cellNum <= row.getLastCellNum(); cellNum++) {
						Cell cell = row.getCell(cellNum);
						if (cell == null) {
							continue;
						}
						arrCell.add(getValue(cell));
					}
					Row.add(arrCell);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return Row;
	}

	/**
	 * ȡֵ
	 * 
	 * @param cell
	 * @return
	 */
	private String getValue(Cell cell) {
		if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			DecimalFormat df = new DecimalFormat("0");
			return df.format(cell.getNumericCellValue());
		} else {
			return String.valueOf(cell.getStringCellValue());
		}
	}
}
