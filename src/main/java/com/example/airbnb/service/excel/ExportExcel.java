package com.example.airbnb.service.excel;

import com.example.airbnb.model.UserDetail;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.airbnb.utils.ColumnInUserDetail.*;

public class ExportExcel {
//    public static void main(String[] args) throws IOException {
//        final List<UserDetail> books = getBooks();
//        final String excelFilePath = "C:/demo/books.xlsx";
//        writeExcel(books, excelFilePath);
//    }

    public  void writeExcel(List<UserDetail> userDetails, String excelFilePath) throws IOException {
        // Create Workbook
        Workbook workbook = getWorkbook(excelFilePath + LocalDateTime.now());

        // Create sheet
        Sheet sheet = workbook.createSheet("Sheet 1" ); // Create sheet with sheet name

        int rowIndex = 0;

        // Write header
        writeHeader(sheet, rowIndex);

        // Write data
        rowIndex++;
        for (UserDetail userDetail : userDetails) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(userDetail, row);
            rowIndex++;
        }

        // Write footer
//        writeFooter(sheet, rowIndex);

        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);

        // Create file excel
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }

    // Create dummy data
//    public List<UserDetail> getBooks() {
//        List<UserDetail> listBook = new ArrayList<>();
//        UserDetail userDetail;
//        for (int i = 1; i <= 5; i++) {
//            userDetail = new UserDetail(i, "UserDetail " + i, i * 2, i * 1000);
//            listBook.add(userDetail);
//        }
//        return listBook;
//    }

    // Create workbook
    public Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
        return workbook;
    }

    // Write header with format
    public void writeHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);

        // Create row
        Row row = sheet.createRow(rowIndex);

        // Create cells
        Cell cell = row.createCell(COLUMN_UID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Id");

        cell = row.createCell(COLUMN_USERNAME);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tên đăng nhập");

        cell = row.createCell(COLUMN_TENTHANH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tên thánh");

        cell = row.createCell(COLUMN_TENGOI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tên gọi");

        cell = row.createCell(COLUMN_GIOITINH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Giới tính");

        cell = row.createCell(COLUMN_NGAYSINH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày sinh");

        cell = row.createCell(COLUMN_SODIENTHOAICANHAN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số điện thoại cá nhân");

        cell = row.createCell(COLUMN_EMAIL);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Email");

        cell = row.createCell(COLUMN_NGAYRUATOI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày rửa tội");

        cell = row.createCell(COLUMN_NGUOIRUATOI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Người rửa tội");

        cell = row.createCell(COLUMN_NGUOIDODAURUATOI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Người đỡ đầu rửa tội");

        cell = row.createCell(COLUMN_NGAYTHEMSUC);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày thêm sức");

        cell = row.createCell(COLUMN_NGUOITHEMSUC);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Người thêm sức");

        cell = row.createCell(COLUMN_NGUOIDODAUTHEMSUC);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Người đỡ đầu thêm sức");

        cell = row.createCell(COLUMN_NGAYBONMANG);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày bổn mạng");

        cell = row.createCell(COLUMN_TENBO);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tên bố");

        cell = row.createCell(COLUMN_SDTBO);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số điện thoại bố");

        cell = row.createCell(COLUMN_TENME);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tên mẹ");

        cell = row.createCell(COLUMN_SDTME);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số điện thoại mẹ");

        cell = row.createCell(COLUMN_DIACHI);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Địa chỉ");

        cell = row.createCell(COLUMN_GIAOXUID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Giáo xứ");

        cell = row.createCell(COLUMN_LOPID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Lớp");

        cell = row.createCell(COLUMN_NGANH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngành");



    }

    // Write data
    public void writeBook(UserDetail userDetail, Row row) {

        Cell cell = row.createCell(COLUMN_UID);
        cell.setCellValue(userDetail.getId());


        cell = row.createCell(COLUMN_USERNAME);
        cell.setCellValue(userDetail.getUsername());


        cell = row.createCell(COLUMN_TENTHANH);
        cell.setCellValue(userDetail.getTenThanh());


        cell = row.createCell(COLUMN_TENGOI);
        cell.setCellValue(userDetail.getTenGoi());


        cell = row.createCell(COLUMN_GIOITINH);
        cell.setCellValue(userDetail.getGioiTinh());

        cell = row.createCell(COLUMN_NGAYSINH);
        cell.setCellValue(userDetail.getNgayThangNamSinh());

        cell = row.createCell(COLUMN_SODIENTHOAICANHAN);
        cell.setCellValue(userDetail.getSoDienThoaiCaNhan());

        cell = row.createCell(COLUMN_EMAIL);
        cell.setCellValue(userDetail.getEmail());

        cell = row.createCell(COLUMN_NGAYRUATOI);
        cell.setCellValue(userDetail.getNgayRuaToi());

        cell = row.createCell(COLUMN_NGUOIRUATOI);
        cell.setCellValue(userDetail.getNguoiRuaToi());

        cell = row.createCell(COLUMN_NGUOIDODAURUATOI);
        cell.setCellValue(userDetail.getNguoiDoDauRuaToi());

        cell = row.createCell(COLUMN_NGAYTHEMSUC);
        cell.setCellValue(userDetail.getNgayThemSuc());

        cell = row.createCell(COLUMN_NGUOITHEMSUC);
        cell.setCellValue(userDetail.getNguoiThemSuc());

        cell = row.createCell(COLUMN_NGUOIDODAUTHEMSUC);
        cell.setCellValue(userDetail.getNguoiDoDauThemSuc());

        cell = row.createCell(COLUMN_NGAYBONMANG);
        cell.setCellValue(userDetail.getNgayBonMang());

        cell = row.createCell(COLUMN_TENBO);
        cell.setCellValue(userDetail.getTenBo());

        cell = row.createCell(COLUMN_SDTBO);
        cell.setCellValue(userDetail.getSdtBo());

        cell = row.createCell(COLUMN_TENME);
        cell.setCellValue(userDetail.getTenMe());

        cell = row.createCell(COLUMN_SDTME);
        cell.setCellValue(userDetail.getSdtMe());

        cell = row.createCell(COLUMN_DIACHI);
        cell.setCellValue(userDetail.getDiaChi());

        cell = row.createCell(COLUMN_GIAOXUID);
        cell.setCellValue(userDetail.getGiaoXuId());

        cell = row.createCell(COLUMN_LOPID);
        cell.setCellValue(userDetail.getLopId());

        cell = row.createCell(COLUMN_NGANH);
        cell.setCellValue(userDetail.getNganh());
    }

    // Create CellStyle for header
    public CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

    // Write footer
//    public void writeFooter(Sheet sheet, int rowIndex) {
//        // Create row
//        Row row = sheet.createRow(rowIndex);
//        Cell cell = row.createCell(COLUMN_INDEX_TOTAL, CellType.FORMULA);
//        cell.setCellFormula("SUM(E2:E6)");
//    }

    // Auto resize column width
    public void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    // Create output file
    public void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }
}
