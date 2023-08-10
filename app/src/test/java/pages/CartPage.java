package pages;

import org.openqa.selenium.TimeoutException;

public class CartPage extends BasePage {

    public CartPage() {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    public Boolean itemIsOnCart(String productTitle){
        try{
            if(elementIsDisplayed("//div[@class='inventory_item_name' and text()=\""+productTitle+"\"]")){
                return true;
            }else{
                return false;
            }
        }catch(TimeoutException e){
            return false;
        }
    }

    public Boolean verifyItemDescription(String description){
        return elementIsDisplayed("//div[@class='inventory_item_desc' and text()=\""+description+"\"]");
    }

    public String getItemPrice(String productTitle){
        return textFromElement("(//div[@class='inventory_item_name' and text()=\""+productTitle+"\"]/following::div[@class='inventory_item_price'])[1]");
    }

    public void removeItem(String item){
        clickElement("(//div[@class='inventory_item_name' and text()=\""+item+"\"]/following::button[.='Remove'])[1]");
    }
}
