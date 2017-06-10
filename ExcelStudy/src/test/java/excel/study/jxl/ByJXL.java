package excel.study.jxl;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 通过JML处理excel.
 * User: huang
 * Date: 17-6-10
 */
public class ByJXL {

    // excel文件
    File file = new File("excel.xls");

    /**
     * 写入Excel.
     */
    @Test
    public void writeExcel() {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            // 创建工作薄
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            // 创建sheet
            WritableSheet sheet = workbook.createSheet("Sheet1" , 0);

            // 添加数据
            Label label = null;
            for (int i = 0; i < 20; i++) {
                label = new Label(i, 0, "你好" + 1);
                sheet.addCell(label);
            }

            // 写入数据
            workbook.write();

            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析Excel.
     */
    @Test
    public void readExcel() throws IOException, BiffException {

        // 获取工作薄
        Workbook workbook = Workbook.getWorkbook(file);
        // 获取第一个sheet
        Sheet sheet = workbook.getSheet(0);

        // 获取数据
        for (int i = 0; i < sheet.getRows(); i++) {
            for (int j = 0; j < sheet.getColumns(); j++) {
                // 获取单元格
                Cell cell = sheet.getCell(j, i);
                System.out.println(cell.getContents());
            }
        }

        workbook.close();
    }
}
