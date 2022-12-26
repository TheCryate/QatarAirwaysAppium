import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class StepImplementation extends BaseTest{

    Random rand = new Random();
    String beforeDepartureTime, afterDepartureTime, beforeArrivalTime, afterArrivalTime;
    Logger logger = LogManager.getLogger(StepImplementation.class);

    @Step("<x> saniye kadar bekle") //Örnek Step (Sil ve yerine başka birşey bul.)
    public void waitForSeconds(int x) throws InterruptedException{
        Thread.sleep(1000*x);
    }

    @Step("Görünür olduğunda tıkla")
    public void waitForClickable(){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable (By.id(""))).click();
    }
    
    @Step("Uygulama Gorunur Olana Kadar Bekle")
    public void waitUntilAppVisible(){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.m.qr:id/rvmp_onboarding_initial_page_layout_root_view")));
    }

    @Step("Uygulamanın Acildigini Kontrol Et")
    public void checkApp() {
        MobileElement element = appiumDriver.findElement(By.id("com.m.qr:id/rvmp_onboarding_initial_page_layout_root_view"));
        if (element.isDisplayed()) {
            logger.info("Uygulama Basariyla Baslatildi");
            System.out.println("Uygulama Basariyla Baslatildi");
        }else {
            logger.info("Uygulama Baslatilamadi");
            System.out.println("Uygulama Baslatilamadi");
        }
    }
    
    @Step("Lokasyon Servislerini Gec")
    public void skipLocation(){
        appiumDriver.findElement(By.id("com.m.qr:id/skip_button")).click();
    }
    
    @Step("Karsilama Ekranini Gec")
    public void skipWelcomeScreen(){
        appiumDriver.findElement(By.id("com.m.qr:id/onboarding_skip_button")).click();
    }

    @Step("Decline Gorunur Olana Kadar Bekle")
    public void waitUntilDeclineVisible(){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.m.qr:id/push_consent_decline")));
    }

    @Step("Decline'a Bas")
    public void clickDecline() {
        appiumDriver.findElement(By.id("com.m.qr:id/push_consent_decline")).click();
    }

    @Step("Book Tabanina Gecis Yap")
    public void waitForBookClickable(){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable (By.id("com.m.qr:id/nav_menu_book"))).click();
    }

    @Step("Book Tabanına Geçiş Yap(afk)")
    public void clickBook() {
        appiumDriver.findElement(By.id("com.m.qr:id/nav_menu_book")).click();
    }

    @Step("One-Way Seyahat Tipine Tikla")
    public void clickOneWay(){
        appiumDriver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='One-way']")).click();
    }

    @Step("Kalkis Yeri Sece Tikla")
    public void from(){
        appiumDriver.findElement(By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_origin_holder")).click();
    }

    @Step("Kalkis Arama Yerine <value> Yaz")
    public void sendKeyBerlin(String value){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext")));
        MobileElement element = appiumDriver.findElement(By.id("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext"));
        element.clear();
        element.sendKeys(value);
    }

    @Step("Berlin'i Sec")
    public void chooseBerlin(){
        appiumDriver.findElement(By.id("com.m.qr:id/rvmp_item_ond_selection_list_text_view_holder")).click();
        logger.info("Kalkis Yeri Olarak Berlin Secildi.");
    }

    @Step("Varis Yeri Sece Tikla")
    public void to(){
        appiumDriver.findElement(By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_destination_select_destination_text_view")).click();
    }

    @Step("Varis Arama Yerine <value> Yaz")
    public void sendKeyIstanbul(String value){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext")));
        MobileElement element = appiumDriver.findElement(By.id("com.m.qr:id/rvmp_fragment_ond_selection_filter_edittext"));
        element.clear();
        element.sendKeys(value);
    }

    @Step("Istanbul'u Sec")
    public void chooseIstanbul(){
        appiumDriver.findElement(By.id("com.m.qr:id/rvmp_item_ond_selection_list_text_view_holder")).click();
        logger.info("Varis Yeri Olarak İstanbul Secildi.");
    }

    @Step("Gidis Tarihi Sece Tikla")
    public void departure(){
        appiumDriver.findElement(By.id("com.m.qr:id/rvmp_fragment_rtow_flight_selection_departure_date_holder")).click();
    }

    @Step("Gunumuzden 7 Gun Sonrasini Sec")
    public void afterSevenDays(){
        MobileElement element = appiumDriver.findElement(By.id("com.m.qr:id/drawer_root"));
        //new Actions(appiumDriver);
        Actions action = new Actions(appiumDriver);

                for(int i = 0; i<8; i++){
                    action.sendKeys(Keys.TAB).perform();
                }
        action.sendKeys(Keys.ENTER).perform();
        appiumDriver.findElement(By.id("com.m.qr:id/fragment_calendar_confirm_button")).click();
        logger.info("Tarih secimi basarili.");
    }

    @Step("Ucus Ara")
    public void searchFlight(){
        appiumDriver.findElement(By.id("com.m.qr:id/rvmp_booking_search_flights_button")).click();
    }

    @Step("Ucus Secim Ekraninin Geldigini Kontrol Et")
    public void checkFlight() {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.m.qr:id/booking_activity_conversational_message")));
        MobileElement element = appiumDriver.findElement(By.id("com.m.qr:id/booking_activity_conversational_message"));
        if (element.isDisplayed()) {
            logger.info("Ucus Secim Ekrani Basariyla Cagirildi");
            System.out.println("Ucus Secim Ekrani Basariyla Cagirildi");
        }else {
            logger.info("Ucus Secim Ekrani Çagirilamadi");
            System.out.println("Ucus Secim Ekrani Çagirilamadi");
        }
    }

    @Step("Ucus Sayfasini Asagi Kaydir")
    public void swipeFlightPage(){

        final int PRESS_TIME = 200; // ms

        //int edgeBorder = 300; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = appiumDriver.manage().window().getSize();
        pointOptionStart = PointOption.point(696, 2174);
        pointOptionEnd = PointOption.point(706, 1662);
        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
    }

    @Step("Rastgele Ucus Seec")
    public void selectRandomFlight(){
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.m.qr:id/rvmp_fragment_search_result_list")));
        MobileElement flights = appiumDriver.findElement(By.id("com.m.qr:id/rvmp_fragment_search_result_list"));
        List<MobileElement> e = flights.findElements(By.id("com.m.qr:id/rvmp_item_search_result_root_view"));
        Random r=new Random();
        e.get(r.nextInt(4)).click();
    }

    @Step("<xpath> 'li uçuşlardan rastgele seç ve <departure> ile <arrival> değerlerini kaydet")
    public void randomSelectFly(String xpath, String departurePath, String arrivalPath) {

        int random = rand.nextInt(4);
        if (random==0){
            random = random+1;
        }
        System.out.println("random: "+random);
        MobileElement departure = appiumDriver.findElement(By.xpath("("+xpath+")["+random+"]/"+departurePath+""));
        beforeDepartureTime = departure.getAttribute("text");
        MobileElement arrival = appiumDriver.findElement(By.xpath("("+xpath+")["+random+"]/"+arrivalPath+""));
        beforeArrivalTime = arrival.getAttribute("text");

        MobileElement element = appiumDriver.findElement(By.xpath("("+xpath+")["+random+"]"));
        element.click();
        logger.info("Rastgele ucus secimi basarili.");
    }

    @Step("Ekonomi Classic Secenegine Tikla")
    public void chooseEconomyClassic(){
        appiumDriver.findElement(By.id("com.m.qr:id/rvmp_activity_flight_details_select_button")).click();
    }

    @Step("Uçuş ve varış saatlerinin uyuşması kontrolü")
    public void compareFlyHours() {
        Assert.assertEquals("Uçuş saatlerinin önceki ve sonraki halleri eşit değil!",beforeDepartureTime,afterDepartureTime);
        Assert.assertEquals("Varış saatlerinin önceki ve sonraki halleri eşit değil!",beforeArrivalTime,afterArrivalTime);
    }
}