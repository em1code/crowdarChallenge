package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage() {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    private String problematicImg = "https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg",
            imgItemList = "//div[@class='inventory_item']//img",
            cartButton = "//div[@id='shopping_cart_container']/a";

    public Boolean validateProductItemsPage() {
        List<WebElement> productItems = getAllElements(imgItemList);
        // Debug
        // productItems.forEach(item -> {
        // System.out.println("Item: " + item.getAttribute("src"));
        // });
        boolean allElementsHaveSameSrc = productItems.stream()
                .allMatch(item -> item.getAttribute("src").equals(problematicImg));
        if (allElementsHaveSameSrc) {
            return true;
        } else {
            return false;
        }
    }

    public void addItemToCart(String productName){
        clickElement("//div[@class='inventory_item_name' and text()=\""+productName+"\"]/following::button[1]");
    }

    public String getShoppingCartBudget(){
        return textFromElement("//span[@class='shopping_cart_badge']");
    }

    public void clickOnCartIcon(){
        clickElement(cartButton);
    }
    
}
