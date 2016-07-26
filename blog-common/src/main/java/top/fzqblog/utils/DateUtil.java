package top.fzqblog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import top.fzqblog.po.enums.DateTimePatternEnum;

public class DateUtil {

	  /** 存放不同的日期模板格式的sdf的Map */
	  private static ThreadLocal<Map<String, SimpleDateFormat>> sdfMap = new ThreadLocal<Map<String, SimpleDateFormat>>() {
	    @Override
	    protected Map<String, SimpleDateFormat> initialValue() {
	      return new HashMap<String, SimpleDateFormat>();
	    }
	  };

	  /**
	   * 返回一个SimpleDateFormat,每个线程只会new一次pattern对应的sdf
	   * 
	   * @param pattern
	   * @return
	   */
	  private static SimpleDateFormat getSdf(final String pattern) {
	    Map<String, SimpleDateFormat> tl = sdfMap.get();
	    SimpleDateFormat sdf = tl.get(pattern);
	    if (sdf == null) {
	      sdf = new SimpleDateFormat(pattern);
	      tl.put(pattern, sdf);
	    }
	    return sdf;
	  }

	  /**
	   * 这样每个线程只会有一个SimpleDateFormat
	   * 
	   * @param date
	   * @param pattern
	   * @return
	   */
	  public static String format(Date date, String pattern) {
	    return getSdf(pattern).format(date);
	  }

	  public static Date parse(String dateStr, String pattern)
	      throws ParseException {
	    return getSdf(pattern).parse(dateStr);
	  }
	 /**
	  * 计算两个Date之间差了多少天
	  */
	  public static int daysBetween(Date smdate,Date bdate) 
	    {    
	        SimpleDateFormat sdf=new SimpleDateFormat(DateTimePatternEnum.YYYY_MM_DD.getPattern());  
	        try {
				smdate=sdf.parse(sdf.format(smdate));
		        bdate=sdf.parse(sdf.format(bdate));  
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(smdate);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(bdate);    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	            
	       return Integer.parseInt(String.valueOf(between_days));           
	    }    
	}
