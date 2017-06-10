package excel.study.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

/**
 * 通过POI处理Excel文件.
 * User: huang
 * Date: 17-6-10
 */
public class ByPOI {

    /**
     * 写入低版本Excel.
     */
    @Test
    public void writeLowerExcel() throws IOException {
        // 创建工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建sheet
        HSSFSheet sheet = workbook.createSheet();


        HSSFCell cell = null;
        for (int j = 0; j < 5; j++) {
            // 创建行
            HSSFRow row = sheet.createRow(j);

            for (int i = 0; i < 5 ; i++) {
                cell = row.createCell(i);
                cell.setCellValue("你好 " + i);
            }
        }


        // excel文件
        File file = new File("excel.xls");
        if (!file.exists()) {
            file.createNewFile();
        }

        // 写入文件
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);

        out.close();
        workbook.close();
    }

    /**
     * 解析低版本Excel.
     */
    @Test
    public void readLowerExcel() throws IOException {
        // excel文件
        File file = new File("excel.xls");
        InputStream input = new FileInputStream(file);
        // 获取工作薄
        HSSFWorkbook workbook = new HSSFWorkbook(input);
        // 获取sheet
        //HSSFSheet sheet = workbook.getSheet("Sheet0");
        HSSFSheet sheet = workbook.getSheetAt(0);

        // 读取数据
        // 获取最后一行的行号
        int len = sheet.getLastRowNum();
        for (int i = 0; i <= len; i++) {
            // 获取一行数据
            HSSFRow row = sheet.getRow(i);
            // 获取最后一个单元格列号
            int num = row.getLastCellNum();
            for (int j = 0; j < num; j++) {
                HSSFCell cell = row.getCell(j);
                System.out.println(cell.getStringCellValue());
            }
        }

        input.close();
        workbook.close();
    }

    /**
     * 写入高版本Excel.
     */
    @Test
    public void writeHeightExcel() throws IOException {
        // 创建工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建sheet
        XSSFSheet sheet = workbook.createSheet();


        XSSFCell cell = null;
        for (int j = 0; j < 5; j++) {
            // 创建行
            XSSFRow row = sheet.createRow(j);

            for (int i = 0; i < 5 ; i++) {
                cell = row.createCell(i);
                cell.setCellValue("你好 " + i);
            }
        }


        // excel文件
        File file = new File("excel2.xlsx");
        if (!file.exists()) {
            file.createNewFile();
        }

        // 写入文件
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);

        out.close();
        workbook.close();
    }
}
