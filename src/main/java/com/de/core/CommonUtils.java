package com.de.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.zip.ZipOutputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.googlecode.htmlcompressor.compressor.HtmlCompressor;
import com.googlecode.htmlcompressor.compressor.YuiCssCompressor;

public class CommonUtils {
	public CommonUtils() {
	}

	public static String getdate(String format) {
		DateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		return sdf.format(date);
	}

	public static int getCurrentYear() {
		return Calendar.getInstance().get(1);
	}

	public static int getCurrentMonth() {
		return Calendar.getInstance().get(2);
	}

	public static String doubleUpConvertor(Double number) {
		try {
			DecimalFormat format = new DecimalFormat("###.##");
			format.setRoundingMode(RoundingMode.HALF_EVEN);
			return format.format(number);
		} catch (Exception var2) {
			var2.printStackTrace();
			return null;
		}
	}

	public static String doubleHalfUpConvertor(Double number) {
		try {
			DecimalFormat format = new DecimalFormat("###.##");
			format.setRoundingMode(RoundingMode.HALF_UP);
			return format.format(number);
		} catch (Exception var2) {
			var2.printStackTrace();
			return null;
		}
	}

	public static String doubleHalfUpConvertor(String number) {
		try {
			DecimalFormat format = new DecimalFormat("###.##");
			format.setRoundingMode(RoundingMode.HALF_UP);
			return format.format(Double.parseDouble(number));
		} catch (Exception var2) {
			var2.printStackTrace();
			return null;
		}
	}

	public String  convertDtoToString(Object object) {
		String dtoStringvalue = null;
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		try {
			dtoStringvalue = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException var5) {
			var5.printStackTrace();
		}

		return dtoStringvalue;
	}

	public Map<String, Object> convertDtoToMap(Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		Map<String, Object> map = (Map) objectMapper.convertValue(object, Map.class);
		return map;
	}

	public static String getCompressedHTML(String htmlContent) {
		htmlContent = htmlContent.replaceAll("\t", "");
		htmlContent = htmlContent.replaceAll("\r|\n", "");
		HtmlCompressor compressor = new HtmlCompressor();
		compressor.setRemoveIntertagSpaces(true);
//		compressor.setRemoveSurroundingSpaces("all");
		YuiCssCompressor cssCompressor = new YuiCssCompressor();
		compressor.setCssCompressor(cssCompressor);
		return compressor.compress(htmlContent);
	}

	public static String getPathWithValidSeperator(String path) {
		String UNIX_FILE_SEPARATOR = "/";
		String WINDOWS_FILE_SEPARATOR = "\\\\";
		String changedPath = path;
		if (File.separator.equals("\\\\")) {
			changedPath = path.replaceAll("/", Matcher.quoteReplacement("\\\\"));
		}

		if (File.separator.equals("/")) {
			changedPath = path.replaceAll("\\\\", Matcher.quoteReplacement("/"));
		}

		return changedPath;
	}

	public static void createDirectory(String directoryPath) {
		File file = new File(directoryPath);
		if (!file.exists()) {
			file.mkdirs();
		}

	}

	public static void replaceKeysInFile(String filePath, String destinationFilePath, String... args) {
		try {
			File file = new File(filePath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String text = "";

			String newText;
			for (newText = ""; (text = reader.readLine()) != null; newText = newText + MessageFormat.format(text, args)
					+ System.getProperty("line.separator")) {
			}

			reader.close();
			FileWriter writer = new FileWriter(destinationFilePath);
			writer.write(newText);
			writer.close();
		} catch (Throwable var8) {
			throw new RuntimeException(var8);
		}
	}

	public static void zip(String dirPath) {
        Path sourceDir = Paths.get(dirPath);
        String zipFileName = dirPath.concat(".zip");

        try {
            ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
//            Files.walkFileTree(sourceDir, new 1(sourceDir, outputStream));
            outputStream.close();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

	public static String formatString(String s, Object... valuesToBeReplacePlaceholders) {
		Object[] var2 = valuesToBeReplacePlaceholders;
		int var3 = valuesToBeReplacePlaceholders.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			Object o = var2[var4];
			s = s.replaceFirst("%s", o.toString());
		}

		return s;
	}
}
