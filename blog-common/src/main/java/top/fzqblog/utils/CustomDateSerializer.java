package top.fzqblog.utils;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.ocpsoft.prettytime.PrettyTime;

import top.fzqblog.po.enums.DateTimePatternEnum;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;



/**
 * @description 自定义返回JSON 数据格中日期格式化处理
 */
public class CustomDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, 
			JsonGenerator jsonGenerator, 
			SerializerProvider provider)
			throws IOException, JsonProcessingException {	
		if(DateUtil.daysBetween(value, new Date())> 7){
		SimpleDateFormat sdf = new SimpleDateFormat(DateTimePatternEnum.YYYY_MM_DD_HH_MM.getPattern());
		jsonGenerator.writeString(sdf.format(value));
		}
		else{
			PrettyTime p = new PrettyTime(new Locale("ZH_CN"));
			jsonGenerator.writeString(p.format(value));
		}		
	}
}
