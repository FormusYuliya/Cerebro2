package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Table extends BasePageObject{


    private WebElement tableElement;

    public Table(WebDriver driver, WebElement tableElement) {
        super(driver);
        this.tableElement = tableElement;
    }

    public List<WebElement> getRows(){
        List<WebElement> rows = tableElement.findElements(By.cssSelector("div.CaseRow") );
        return rows;
    }
    public List<List<WebElement>> getRowsWithColumns(){
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for(WebElement row: rows){

            WebElement caseID = row.findElement(By.cssSelector("a.CaseRow__case-number"));
            WebElement status = row.findElement(By.cssSelector("div[class*='CaseStatus']"));
            WebElement assignee = row.findElement(By.cssSelector("div.CaseAssignee>div"));

           List<WebElement> rowWithColumns = new ArrayList<>();
            rowWithColumns.add(caseID);
            rowWithColumns.add(status);
            rowWithColumns.add(assignee);

            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }

    public String getValueFromCell(int rowNumber, int columnNumber){
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        WebElement cell = rowsWithColumns.get(rowNumber).get(columnNumber-1);
        return  cell.getText();
    }
}
