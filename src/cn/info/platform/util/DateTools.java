package cn.info.platform.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ʱ�������
 * 
 * @author HCOU
 */
public final class DateTools extends SimpleDateFormat {
	/**
	 * ע������
	 */
	private static final long serialVersionUID = -2987750868895651661L;

	/**
	 * ʱ���ʽΪyyyy-MM-dd HH:mm:ss
	 */
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * ʱ���ʽΪyyyy-MM-dd HH:mm:ss.sss
	 */
	public static final String YYYY_MM_DD_HH_MM_SS_S = "yyyy-MM-dd HH:mm:ss.SSS";

	/**
	 * ʱ���ʽΪyyyy-MM-dd
	 */
	public static final String YYYY_MM_DD = "yyyy-MM-dd";

	/**
	 * ʱ���ʽΪyyyyMMddHHmmss
	 */
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	/**
	 * ʱ���ʽΪddHHmmss
	 */
	public static final String DDHHMMSS = "ddHHmmss";

	/**
	 * ʱ���ʽΪHHmmss
	 */
	public static final String HHMMSS = "ddHHmmss";

	/**
	 * ʱ���ʽΪyyyy-MM-dd HH:mm
	 */
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

	/**
	 * ʱ���ʽΪyyyy-MM-dd HH
	 */
	public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";

	/**
	 * DATETOOL
	 */
	private static DateTools dateTools = null;

	/**
	 * ������
	 */
	private final Calendar calendar = Calendar.getInstance();

	/**
	 * <Ĭ��˽�й��캯��>
	 */
	private DateTools() {
		super(YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * <Ĭ�Ϲ��캯��>
	 * 
	 * @param mode
	 *            ģ̬
	 */
	private DateTools(String mode) {
		super(mode);
	}

	/**
	 * ���๹������ڹ����಻���Ը�ʽ������
	 * 
	 * @return DateTools
	 */
	public static DateTools getDateTools() {
		if (null == dateTools) {
			dateTools = new DateTools();
		}
		return dateTools;
	}

	/**
	 * ���๹������ڹ�������Ը�ʽ������
	 * 
	 * @param mode
	 *            modeģʽ ������ʱ��ģʽȥ������ת��
	 * @return DateTools
	 */
	public static DateTools getDateTools(String mode) {
		if (null == dateTools) {
			dateTools = new DateTools(mode);
		}
		return dateTools;
	}

	/**
	 * �õ��ᴫ�����ڵ��·�
	 * 
	 * @param date
	 *            ����
	 * @return int
	 * @throws ParseException
	 *             ParseException
	 */
	public int getMonth(Date date) throws ParseException {
		setCalendar(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * �õ��ᴫ�����ڵ����
	 * 
	 * @param date
	 *            ����
	 * @return int
	 * @throws ParseException
	 *             ParseException
	 */
	public int getYear(Date date) throws ParseException {
		setCalendar(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * �õ��ᴫ�����ڵ������������µ���һ��
	 * 
	 * @param date
	 *            ����
	 * @return int
	 * @throws ParseException
	 *             ParseException
	 */
	public int getDate(Date date) throws ParseException {
		setCalendar(date);
		return calendar.get(Calendar.DATE) + 1;
	}

	/**
	 * �õ��ᴫ�����ڵķ���
	 * 
	 * @param date
	 *            ����
	 * @return int
	 * @throws ParseException
	 *             ParseException
	 */
	public int getMinute(Date date) throws ParseException {
		setCalendar(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * �õ��ᴫ�����ڵ�Сʱ
	 * 
	 * @param date
	 *            ����
	 * @param isStandard
	 *            �Ƿ���24Сʱ�Ƶ�,true:��
	 * @return int
	 * @throws ParseException
	 *             ParseException
	 */
	public int getHour(Date date, boolean isStandard) throws ParseException {
		setCalendar(date);
		if (isStandard) {
			return calendar.get(Calendar.HOUR_OF_DAY);
		} else {
			return calendar.get(Calendar.HOUR);
		}
	}

	/**
	 * �õ��ᴫ�����ڵ�Сʱ
	 * 
	 * @param date
	 *            ����
	 * @return int
	 * @throws ParseException
	 *             ParseException
	 */
	public int getSecond(Date date) throws ParseException {
		setCalendar(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * �õ��ᴫ�����ڵ��·�
	 * 
	 * @param strDate
	 *            �ַ�������
	 * @return int
	 * @throws ParseException
	 *             ParseException
	 */
	public int getMonth(String strDate) throws ParseException {
		setCalendar(strDate);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * �õ��ᴫ�����ڵ����
	 * 
	 * @param strDate
	 *            �ַ�������
	 * @return int
	 * @throws ParseException
	 *             ParseException
	 */
	public int getYear(String strDate) throws ParseException {
		setCalendar(strDate);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * �õ��ᴫ�����ڵ������������µ���һ��
	 * 
	 * @param strDate
	 *            �ַ�������
	 * @return int
	 * @throws ParseException
	 *             ParseException
	 */
	public int getDate(String strDate) throws ParseException {
		setCalendar(strDate);
		return calendar.get(Calendar.DATE) + 1;
	}

	/**
	 * �õ��ᴫ�����ڵķ���
	 * 
	 * @param strDate
	 *            �ַ�������
	 * @return int
	 * @throws ParseException
	 *             ParseException
	 */
	public int getMinute(String strDate) throws ParseException {
		setCalendar(strDate);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * �õ��ᴫ�����ڵ�Сʱ
	 * 
	 * @param strDate
	 *            �ַ�������
	 * @param isStandard
	 *            �Ƿ���24Сʱ�Ƶ�,true:��
	 * @return int
	 * @throws ParseException
	 *             ParseException
	 */
	public int getHour(String strDate, boolean isStandard)
			throws ParseException {
		setCalendar(strDate);
		if (isStandard) {
			return calendar.get(Calendar.HOUR_OF_DAY);
		} else {
			return calendar.get(Calendar.HOUR);
		}
	}

	/**
	 * �õ��ᴫ�����ڵ�Сʱ
	 * 
	 * @param strDate
	 *            �ַ�������
	 * @return int
	 * @throws ParseException
	 *             ParseException
	 */
	public int getSecond(String strDate) throws ParseException {
		setCalendar(strDate);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * ��ԭ�е�ʱ��Сʱ�ϼ��ϻ��ȥ����
	 * 
	 * @param date
	 *            ԭ��ʱ��
	 * @param levevHour
	 *            Ҫ�Ӽ���Сʱ��
	 * @param isStandard
	 *            �ǻ���24Сʱ��
	 * @return Date
	 */
	public Date operationHour(Date date, int levevHour, boolean isStandard) {
		setCalendar(date);
		if (isStandard) {
			calendar.add(Calendar.HOUR_OF_DAY, levevHour);
		} else {
			calendar.add(Calendar.HOUR, levevHour);
		}
		return calendar.getTime();
	}

	/**
	 * ��ԭ�е�ʱ������ϼ��ϻ��ȥ����
	 * 
	 * @param date
	 *            ԭ��ʱ��
	 * @param levevMinute
	 *            Ҫ�Ӽ��ķ�����
	 * @return Date
	 */
	public Date operationMinute(Date date, int levevMinute) {
		setCalendar(date);
		calendar.add(Calendar.MINUTE, levevMinute);
		return calendar.getTime();
	}

	/**
	 * ��ԭ�е�ʱ������ϼ��ϻ��ȥ����
	 * 
	 * @param date
	 *            ԭ��ʱ��
	 * @param levevYear
	 *            Ҫ�Ӽ��������
	 * @return Date
	 */
	public Date operationYear(Date date, int levevYear) {
		setCalendar(date);
		calendar.add(Calendar.YEAR, levevYear);
		return calendar.getTime();
	}

	/**
	 * ��ԭ�е�ʱ���·��ϼ��ϻ��ȥ����
	 * 
	 * @param date
	 *            ԭ��ʱ��
	 * @param levevMonth
	 *            Ҫ�Ӽ����·���
	 * @return Date
	 */
	public Date operationMonth(Date date, int levevMonth) {
		setCalendar(date);
		calendar.add(Calendar.MONTH, levevMonth);
		return calendar.getTime();
	}

	/**
	 * ��ԭ�е�ʱ���·��ϼ��ϻ��ȥ����
	 * 
	 * @param date
	 *            ԭ��ʱ��
	 * @param levevDate
	 *            Ҫ�Ӽ����·���
	 * @return Date
	 */
	public Date operationDate(Date date, int levevDate) {
		setCalendar(date);
		calendar.add(Calendar.DATE, levevDate);
		return calendar.getTime();
	}

	/**
	 * ��ԭ�е�ʱ�����ϼ��ϻ��ȥ����
	 * 
	 * @param date
	 *            ԭ��ʱ��
	 * @param levevSecond
	 *            Ҫ�Ӽ�������
	 * @return Date
	 */
	public Date operationSecond(Date date, int levevSecond) {
		setCalendar(date);
		calendar.add(Calendar.SECOND, levevSecond);
		return calendar.getTime();
	}

	/**
	 * ��ԭ�е�ʱ��Сʱ�ϼ��ϻ��ȥ����(�ַ���ʱ��)
	 * 
	 * @param strDate
	 *            ԭ��ʱ��
	 * @param levevHour
	 *            Ҫ�Ӽ���Сʱ��
	 * @param isStandard
	 *            �ǻ���24Сʱ��
	 * @return String
	 * @throws ParseException
	 *             ParseException
	 */
	public String operationHour(String strDate, int levevHour,
			boolean isStandard) throws ParseException {
		setCalendar(strDate);
		if (isStandard) {
			calendar.add(Calendar.HOUR_OF_DAY, levevHour);
		} else {
			calendar.add(Calendar.HOUR, levevHour);
		}
		return format(calendar.getTime());
	}

	/**
	 * ��ԭ�е�ʱ������ϼ��ϻ��ȥ����
	 * 
	 * @param strDate
	 *            ԭ��ʱ��
	 * @param levevMinute
	 *            Ҫ�Ӽ��ķ�����
	 * @return String
	 * @throws ParseException
	 *             ParseException
	 */
	public String operationMinute(String strDate, int levevMinute)
			throws ParseException {
		setCalendar(strDate);
		calendar.add(Calendar.MINUTE, levevMinute);
		return format(calendar.getTime());
	}

	/**
	 * ��ԭ�е�ʱ������ϼ��ϻ��ȥ����
	 * 
	 * @param strDate
	 *            ԭ��ʱ��
	 * @param levevYear
	 *            Ҫ�Ӽ��������
	 * @return String
	 * @throws ParseException
	 *             ParseException
	 */
	public String operationYear(String strDate, int levevYear)
			throws ParseException {
		setCalendar(strDate);
		calendar.add(Calendar.YEAR, levevYear);
		return format(calendar.getTime());
	}

	/**
	 * ��ԭ�е�ʱ���·��ϼ��ϻ��ȥ����
	 * 
	 * @param strDate
	 *            ԭ��ʱ��
	 * @param levevMonth
	 *            Ҫ�Ӽ����·���
	 * @return Date
	 * @throws ParseException
	 *             ParseException
	 */
	public String operationMonth(String strDate, int levevMonth)
			throws ParseException {
		setCalendar(strDate);
		calendar.add(Calendar.MONTH, levevMonth);
		return format(calendar.getTime());
	}

	/**
	 * ��ԭ�е�ʱ���·��ϼ��ϻ��ȥ����
	 * 
	 * @param strDate
	 *            ԭ��ʱ��
	 * @param levevDate
	 *            Ҫ�Ӽ����·���
	 * @return Date
	 * @throws ParseException
	 *             ParseException
	 */
	public String operationDate(String strDate, int levevDate)
			throws ParseException {
		setCalendar(strDate);
		calendar.add(Calendar.DATE, levevDate);
		return format(calendar.getTime());
	}

	/**
	 * ��ԭ�е�ʱ�����ϼ��ϻ��ȥ����
	 * 
	 * @param strDate
	 *            ԭ��ʱ��
	 * @param levevSecond
	 *            Ҫ�Ӽ�������
	 * @return Date
	 * @throws ParseException
	 *             ParseException
	 */
	public String operationSecond(String strDate, int levevSecond)
			throws ParseException {
		setCalendar(strDate);
		calendar.add(Calendar.SECOND, levevSecond);
		return format(calendar.getTime());
	}

	/**
	 * ��������ʱ���֮��ļ��(��)
	 * 
	 * @param srcDate
	 *            ʱ���1
	 * @param destDate
	 *            ʱ���2
	 * @return int
	 * @throws ParseException
	 *             ParseException
	 */
	public int getDaysOperationDate(Date srcDate, Date destDate)
			throws ParseException {
		return (int) StrictMath
				.abs((srcDate.getTime() - destDate.getTime()) / 30);
	}

	/**
	 * ��������ʱ���֮��ļ��(��)
	 * 
	 * @param strSrcDate
	 *            ʱ���1
	 * @param strDestDate
	 *            ʱ���2
	 * @return int
	 * @throws ParseException
	 *             ParseException
	 */
	public int getDaysOperationDate(String strSrcDate, String strDestDate)
			throws ParseException {
		return (int) StrictMath.abs((parse(strSrcDate).getTime() - parse(
				strDestDate).getTime()) / 30);
	}

	/**
	 * �ж��û������ʱ���Ƿ��������ʱ�����
	 * 
	 * @param afterDate
	 *            ����ʱ��
	 * @param beforeDate
	 *            ��ʼʱ��
	 * @param currentDate
	 *            �û������ʱ��
	 * @return boolean true:�ǽ�������ʱ���֮��
	 */
	public boolean compareDate(Date afterDate, Date beforeDate, Date currentDate) {
		if (currentDate.after(beforeDate) && currentDate.before(afterDate)) {
			return true;
		}
		return false;
	}

	/**
	 * �ж��û������ʱ���Ƿ��������ʱ�����(�ַ���ʱ��)
	 * 
	 * @param strAfterDate
	 *            ����ʱ��
	 * @param strBeforeDate
	 *            ��ʼʱ��
	 * @param strCurrentDate
	 *            �û������ʱ��
	 * @return boolean true:�ǽ�������ʱ���֮��
	 * @throws ParseException
	 *             ParseException
	 */
	public boolean compareDate(String strAfterDate, String strBeforeDate,
			String strCurrentDate) throws ParseException {
		Date currentDate = parse(strCurrentDate);
		if (currentDate.after(parse(strBeforeDate))
				&& currentDate.before(parse(strAfterDate))) {
			return true;
		}
		return false;
	}

	/**
	 * ����ϵͳ�ĵ�ǰʱ��,���ַ�����ʽ
	 * 
	 * @return String
	 */
	public String getSystemStrDate() {
		return format(new Date());
	}

	/**
	 * ����������ʱ��
	 */
	private void setCalendar(Date date) {
		calendar.setTime(date);
	}

	/**
	 * ����������ʱ��
	 */
	private void setCalendar(String strDate) throws ParseException {
		calendar.setTime(parse(strDate));
	}

	/**
	 * �жϵ�ǰʱ���Ƿ���ڿ�ʼʱ��ͽ���ʱ��
	 * 
	 * @param startTime
	 *            ��ʼʱ��
	 * @param endTime
	 *            ����ʱ��
	 * @return boolean
	 * @throws ParseException
	 *             ParseException
	 */
	public boolean compareDate(String startTime, String endTime)
			throws ParseException {
		Date currentDate = new Date();
		String strCurrentTime = format(currentDate);
		String time = strCurrentTime.substring(0,
				strCurrentTime.indexOf(" ") + 1);
		Date startDate = parse(time + startTime);
		Date endDate = parse(time + endTime);
		if (currentDate.before(startDate)) {
			if (currentDate.before(endDate)) {
				return true;
			}
		} else if (endDate.before(startDate)) {
			if (currentDate.after(startDate)) {
				return true;
			}
		} else {
			if (currentDate.after(startDate) && currentDate.before(endDate)) {
				return true;
			}
		}
		return false;
	}
}