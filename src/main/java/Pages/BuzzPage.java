package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BuzzPage {

    private final WebDriver driver;
    private final By BuzzButton = By.xpath("//span[text()='Buzz']");
    private final By PostTextBox = By.xpath("//textarea[contains(@class,'oxd-buzz-post-input')]");
    private final By PostButton = By.xpath("(//button[@type='submit'])");
    private final By LikeIcon = By.id("heart");
    private final By CommentIcon = By.xpath("(//i[@class='oxd-icon bi-chat-text-fill'])");
    private final By CommentTextBox = By.xpath("(//input[@placeholder='Write your comment...'])");
    private final By PostSetting = By.xpath("(//button[@type='button'])[9]");
    private final By DeletePost = By.xpath("(//p[normalize-space()='Delete Post'])");
    private final By YesButton = By.xpath("(//button[normalize-space()='Yes, Delete'])");
    private final By SuccessfulMessage = By.xpath("//div[contains(@class,'oxd-toast-content')]");
    private final By DeletedMessage = By.xpath("//div[contains(@class,'oxd-toast-content')]");
    private final By LikeCount = By.xpath("(//p[@class='oxd-text oxd-text--p orangehrm-buzz-stats-active'][normalize-space()='1 Like'])");




    public BuzzPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public BuzzPage clickOnBuzzButton()
    {
        ElementActions.clickElement(driver,BuzzButton);
        return this;
    }

    public BuzzPage writePost(String post)
    {
        ElementActions.sendKeys(driver,PostTextBox,post);
        return this;
    }

    public BuzzPage clickOnPostButton()
    {
        ElementActions.clickElement(driver,PostButton);
        return this;
    }

    public BuzzPage clickOnLikeIcon()
    {
        ElementActions.clickElement(driver,LikeIcon);
        return this;
    }

    public BuzzPage clickOnCommentIcon()
    {
        ElementActions.clickElement(driver,CommentIcon);
        return this;
    }

    public BuzzPage writeComment(String comment)
    {
        ElementActions.sendKeys(driver,CommentTextBox,comment);
        driver.findElement(CommentTextBox).sendKeys(Keys.ENTER);
        return this;
    }


    public BuzzPage clickOnPostSetting()
    {
        ElementActions.clickElement(driver,PostSetting);
        return this;
    }


    public BuzzPage clickOnDeletePost()
    {
        ElementActions.clickElement(driver,DeletePost);
        return this;
    }

    public BuzzPage clickOnYesButton()
    {
        ElementActions.clickElement(driver,YesButton);
        return this;
    }

    public String getTextOfSuccessfulMessage()
    {
        return ElementActions.getText(driver,SuccessfulMessage);
    }

    public String getTextOfLikeCount()
    {
        return ElementActions.getText(driver,LikeCount);
    }

    public String getTextOfDeletedMessage()
    {
        return ElementActions.getText(driver,DeletedMessage);
    }

}
