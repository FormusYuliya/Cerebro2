package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DashboardPage extends BasePageObject {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.View__header>h1")
    private WebElement pageTitle;

    @FindBy(css = "div.CaseRow")
    private List<WebElement> caseRows;

    @FindBy(css = "div.Cases")
    private List<WebElement> caseTable;

    public static List<ArrayList<String>> list = new ArrayList<>();


    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void StrangeMethod2() {
        System.out.println(caseRows.size());
    }

    public void StrangeFeature(){
//        caseRows.stream().forEach(e->);

    }

//    public List<ContainerRow> getContainersRow() {
//        return caseRows.stream().map(e -> {
//            String name = e.findElement(By.cssSelector("a.CaseRow__case-number")).getText().trim();
//            String assignee = e.findElement(By.cssSelector("div.CaseAssignee>div")).getText().trim();
//            return new ContainerRow(name, assignee);
//        }).collect(Collectors.toList());
//    }
//
//    public List<ContainerRow> getContainersRowsByAssignee(String assign) {
//        return getContainersRow().stream().filter(e -> e.getAssigne().contains(assign)).collect(Collectors.toList());
//    }

    public List<CaseRowRow> getRows() {

        return caseRows.stream().map(e -> new CaseRowRow(driver, e)).collect(Collectors.toList());
    }

    public List<ContainerRow> getContainerRows() {
        return getRows().stream().map(e -> new ContainerRow(e.getCaseID(), e.getAssignee())).collect(Collectors.toList());
    }

    public class ContainerRow {
        private String name;
        private String assigne;

        public ContainerRow(String name, String assigne) {
            this.name = name;
            this.assigne = assigne;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAssigne() {
            return assigne;
        }

        public void setAssigne(String assigne) {
            this.assigne = assigne;
        }
    }

    public class CaseRowRow extends BasePageObject {

        private WebElement root;

        private By caseIdLocator = By.cssSelector("a.CaseRow__case-number");

        @FindBy(css = "div[class*='CaseStatus']")
        private WebElement status;
        @FindBy(css = "div.CaseAssignee>div")
        private WebElement assignee;

        public CaseRowRow(WebDriver driver, WebElement root) {
            super(driver);
            this.root = root;
        }


        protected String getCaseID() {
            return getSubElement(root, caseIdLocator).getText().trim();
        }

        protected String getStatus() {
            return status.getText().trim();
        }

        protected String getAssignee() {
            return assignee.getText().trim();
        }

        public void fillList() {
            ArrayList<String> a1 = new ArrayList<String>();
            a1.add(getCaseID());
            a1.add(getStatus());
            a1.add(getAssignee());
            list.add(a1);
        }



    }
}

//    public void getCasesList(){
//        System.out.println(caseRows.size());
//        caseRows.stream().map(e -> (new CaseRowContainer()).name = e.getText()).collect(Collectors.toList());
//
//        caseRows.stream().map(e ->  (new CaseRowContainer()).name = e.getText()).collect(Collectors.toList());
//        WebElement element = caseRows.stream().filter(e-> {
//            String text = e.getText().trim();
//            return text.equals("faasas");
//        }).findFirst().orElseThrow(() -> new AssertionError("Element absent"));
//    }
//
//    public void strangeTest(){
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//        list.forEach(n -> System.out.println(n));
//
//    }
//