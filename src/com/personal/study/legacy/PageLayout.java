//Extract and Override Call 363
package com.personal.study.legacy;

import java.util.ArrayList;
import java.util.List;

public class PageLayout {
  private int id = 0;
  private List styles;
  private StyleTemplate template;
  
  protected void rebindStyles(){
	  styles = StyleMaster.formStyles(template, id);
  }
}

class StyleTemplate {
	
}

class StyleMaster {
	  static List formStyles(StyleTemplate template, int id){
		  return new ArrayList();
	  }
}