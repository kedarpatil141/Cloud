package com.ingestion.processor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ingestion.model.IngestionJobDTO;
import com.ingestion.utils.IngestionRowMapper;

public class ExcelProcessor {

	private final String filePath;

	public ExcelProcessor(String filePath) {
		this.filePath = filePath;
	}

	public List<Asset> processExcel() {
		List<Asset> jobDetailsList = new ArrayList<>();
		try {

			FileInputStream excelFile = new FileInputStream(new File(filePath));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			int rowCount = 0;
			List<Object> rowContent = null;

			while (iterator.hasNext()) {
				rowCount++;

				Row currentRow = iterator.next();
				if (rowCount <=2)
					continue;
				rowContent = new ArrayList<>();

				Iterator<Cell> cellIterator = currentRow.iterator();

				while (cellIterator.hasNext()) {
					Cell currentCell = cellIterator.next();
					if (currentCell.getCellTypeEnum() == CellType.STRING) {
						rowContent.add(currentCell.getStringCellValue());
					} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
						rowContent.add(currentCell.getNumericCellValue());
					}

				}

				if(rowContent.size()>0) {
					Asset assetDetails = new IngestionRowMapper().map(rowContent);
					jobDetailsList.add(assetDetails);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jobDetailsList;
	}
}
