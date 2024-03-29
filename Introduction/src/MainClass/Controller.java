package MainClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import CommonClasses.Constants;
import CommonClasses.SetupDriver;
import RahulPractice.Autocomplete;
import RahulPractice.Autodrop;
import RahulPractice.Controlgroup;
import RahulPractice.Droppable;
import RahulPractice.Makemytrip;
import RahulPractice.Multiwindow;
import RahulPractice.NestedFrame;
import RahulPractice.Resizable;
import RahulPractice.Selectable;
import RahulPractice.Sortable;
import RealPractice.ColorPicker;
import RealPractice.Range;
import RealPractice.Steps;
import RealPractice.TooltipImage;

public class Controller {

	public static void main(String[] args) throws InterruptedException, IOException {

		// TODO Auto-generated method stub

		// driver.switchTo().frame(0);
		// Setup mySetup = new
		// Setup("https://www.globalsqa.com/demo-site/accordion-and-tabs/");
		// Slider mySlider = new Slider("https://www.globalsqa.com/demo-site/sliders/");

		// Setting up slider
		// mySlider.sliderInput("Color Picker");

		// SetupDriver

		SetupDriver driverSetup = new SetupDriver();
		WebDriver driver = driverSetup.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//MakemyTrip
		//Makemytrip makeMytrip = new Makemytrip();
		//makeMytrip.makeMytrip(driver);
		
		
		  //Autodrop 
			Controlgroup controlGroup = new Controlgroup();
		  controlGroup.controlGroup(driver);
		 
		/*
		 * //Autodrop Autodrop autoDrop = new Autodrop();
		 * autoDrop.autodrop(driver);
		 */
		
		
		/*
		 * Autocomplete autocomplete = new Autocomplete();
		 * autocomplete.autocomplete(driver);
		 */
		/*
		 * //NestedFrame NestedFrame nested = new NestedFrame();
		 * nested.nestedFrame(driver);
		 */
		/*
		 * // Setting up Sortable
		 * 
		 * 
		 * Sortable sort = new Sortable(); sort.sortable(driver);
		 */

		// Setting up Selectable

//		Selectable select = new Selectable();
//		select.selectable(driver);
//
//		// Setting up Resizable
//
//		Resizable resize = new Resizable();
//		resize.resizable(driver);
//
//		// Setting up multiple window
//
//		Droppable drop1 = new Droppable();
//		drop1.droppable(driver);

		// Setting up multiple window
		/*
		 * Multiwindow multiWindow = new Multiwindow(); multiWindow.windowSwitch(driver);
		 */

		/*
		 * // Setting up ColorPicker ColorPicker myColorPicker = new ColorPicker();
		 * myColorPicker.colorPickerInput("Color Picker", driver);
		 * 
		 * // Setting up Range Range myRange = new Range(); myRange.rangeInput("Range",
		 * driver);
		 * 
		 * // Setting up Steps Steps mySteps = new Steps(); mySteps.stepsInput("Steps",
		 * driver);
		 * 
		 * // Setting up ImageBased TooltipImage myTooltipImage = new TooltipImage();
		 * myTooltipImage.imageInput("Image Based", driver);
		 */

		driver.quit();

		// setting up Accordion
		// mySetup.simpleAccordion("Simple Accordion");
		// mySetup.setupMainBrowser("https://www.globalsqa.com/demo-site/accordion-and-tabs/");
		/*
		 * mySetup.simpleAccordion("Simple Accordion"); Thread.sleep(2000);
		 * mySetup.simpleAccordion("Re-Size Accordion"); Thread.sleep(2000);
		 * mySetup.simpleAccordion("Toggle Icons");
		 */

	}

}
