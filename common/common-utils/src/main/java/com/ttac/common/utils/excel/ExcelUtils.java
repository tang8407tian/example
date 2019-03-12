package com.ttac.common.utils.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletResponse;


/**
 * Excel工具类
 * 
 * @author chenl
 * @since 2018年03月30日 14:00
 */
@Slf4j
public class ExcelUtils {
	public static <T> void write(List<T> list, OutputStream os) throws IOException {
		Workbook wb;
		try {
			wb = createWorkBook(list);
			wb.write(os);
			wb.close();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private static <T> Workbook createWorkBook(List<T> list) throws IllegalArgumentException, IllegalAccessException {
		Workbook wb = new HSSFWorkbook();
		list.removeAll(Collections.singleton(null));
		if (list.isEmpty()) {
			return wb;
		}
		T t = list.get(0);
		Sheet sheet = wb.createSheet();
		Row row = sheet.createRow(0);
		//写入列头
		String[] hearders = getHeaders(t);
		for (int i = 0; i < hearders.length; i++) {
			row
			.createCell(i)
			.setCellValue(hearders[i]);
		}
		
		//写入数据
		String[] values = null;
		for (int i = 0,len = list.size(); i < len; i++) {
			values = getValues(list.get(i));
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values.length; j++) {
				row
				.createCell(j)
				.setCellValue(values[j]);
			}
		}
		
		return wb;
	}

	private static <T> String[] getValues(T t) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = getAllFields(t);
		Field field = null;
		List<String> valueList = new ArrayList<>();
		for (int i = 0; i < fields.length; i++) {
			field = fields[i];
			ExcelColumn ec = field.getAnnotation(ExcelColumn.class);
			if (ec == null) {
				continue;
			}
			field.setAccessible(true);
			Class<?> type = field.getType();
			Object value = field.get(t);
			if (value == null) {
				valueList.add("");
			} else if (type == Date.class || type == Timestamp.class) {
				Date date = type == Date.class ? (Date)value : new Date(((Timestamp)value).getTime());
				valueList.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
			} else {
				valueList.add(String.valueOf(value));
			}
		}
		return valueList.toArray(new String[valueList.size()]);
	}

	private static <T> String[] getHeaders(T t) {
		Field[] fields = getAllFields(t);
		Field field = null;
		List<String> headerList = new ArrayList<>();
		for (int i = 0; i < fields.length; i++) {
			field = fields[i];
			ExcelColumn ec = field.getAnnotation(ExcelColumn.class);
			if (ec == null) {
				continue;
			}
			headerList.add(ec.name());
		}
		return headerList.toArray(new String[headerList.size()]);
	}
	
	private static <T> Field[] getAllFields(T t) {
		List<Field> fields = new ArrayList<>();
		Class<?> tempClass = t.getClass();
		while (tempClass != null) {
				fields.addAll(Arrays.asList(tempClass.getDeclaredFields()));
		      tempClass = tempClass.getSuperclass();
		}
		return fields.toArray(new Field[fields.size()]);
	}

	public static <T> void write(T t, OutputStream os) throws IOException {
		List<T> list = new ArrayList<>();
		list.add(t);
		write(list, os);
	}

	/**
	 * 导出
	 *
	 * @param response
	 * @param list
	 * @param exportName
	 * @param <T>
	 */
	public static  <T> void export(HttpServletResponse response, List<T> list, String exportName) {
		String filename = null;
		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(exportName).append(".xls");
			filename = URLEncoder.encode(stringBuilder.toString(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error("生成<{}.xls>名称出错！", exportName);
			e.printStackTrace();
		}
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");

		try {
			ExcelUtils.write(list, response.getOutputStream());
		} catch (IOException e) {
			log.error("导出:{}.xls出错！", exportName);
			e.printStackTrace();
		}
	}
}
