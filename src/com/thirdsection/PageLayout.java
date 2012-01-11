//Extract and Override Call 363
package com.thirdsection;

import java.util.ArrayList;
import java.util.List;

public class PageLayout {
  private int id = 0;
  private List styles;
  private StyleTemplate template;
  
  protected void rebindStyles(){
	  styles = formStyles(template, id);
  }

  //Dependency toward StyleMaster can be removed with overriding this method.
  protected List formStyles(StyleTemplate template, int id){
	  return StyleMaster.formStyles(template, id);
  }
}

class StyleTemplate {
	
}

class StyleMaster {
	  static List formStyles(StyleTemplate template, int id){
		  return new ArrayList();
	  }
}