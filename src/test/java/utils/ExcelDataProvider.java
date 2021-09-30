package utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

public class ExcelDataProvider {

    public static final String defaultSortTestDataFile = "src/test/testData/SortingTestData.xlsx";
    public static final String defautSearchTestData = "src/test/testData/SearchTestData.xlsx";
    public static final String defaultSheetName= "Sheet1";

    @DataProvider(name ="SortTestData")
    public Object[][] excelDP(ITestContext context) {
        List<String> includedGroups = Arrays.asList(context.getIncludedGroups());
        Object[][] arrObj = null ;
        if(includedGroups.contains("Eng")) {
            arrObj =  getExcelData(defaultSortTestDataFile, defaultSheetName);
        }
        else if (includedGroups.contains("Fr")) {
            arrObj = getExcelData(defaultSortTestDataFile, defaultSheetName);
        }

        return arrObj;
    }

    @DataProvider(name ="SearchTestData")
    public Object[][] SearchDP(ITestContext context) {
        List<String> includedGroups = Arrays.asList(context.getIncludedGroups());
        Object[][] arrObj = null ;
        if(includedGroups.contains("Eng")) {
            arrObj =  getExcelData(defautSearchTestData, defaultSheetName);
        }
        else if (includedGroups.contains("Fr")) {
            arrObj = getExcelData(defautSearchTestData, defaultSheetName);
        }

        return arrObj;
    }

    public Object[][] getExcelData(String fileName, String sheetName) {

        Object[][] data = null;
        Workbook wb = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            String fileExtensionName = fileName.substring(fileName.indexOf("."));

            if(fileExtensionName.equals(".xlsx"))
                wb = new XSSFWorkbook(fis);
            else if(fileExtensionName.equals(".xls")){
                wb = new HSSFWorkbook(fis);
            }
            Sheet sh = wb.getSheet(sheetName);
            Row row = sh.getRow(0);
            int noOfRows = sh.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new Object[noOfRows - 1][noOfCols];
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sh.getRow(i);
                    cell = row.getCell(j);

                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING :
                            data[i - 1][j] = cell.getStringCellValue(); //1,1
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            data[i - 1][j] = (int)cell.getNumericCellValue();
                            break;
                        case Cell.CELL_TYPE_BLANK:
                            data[i - 1][j] = "";
                            break;
                        default:
                            data[i - 1][j] = null;
                            break;
                    }

                }
            }
        }

        catch (Exception e) {
            Log.error("The exception is: " + e.getMessage());
        }

        return data;
    }
}
