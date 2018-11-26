/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

/**
 *
 * @author rafikhan
 */
public class EmailValidation {
    static public boolean validate(String string){
        int name=0;
        int domainName=0;
        int domain=0;
        int at=0;
        int dot=0;
        boolean nameDone=false;
        boolean domainNameDone=false;
        
        for(int i=0;i<string.length();i++){
            if(string.charAt(i)=='@'){
                nameDone=true;
                at++;
            }
            if(!nameDone||string.charAt(i)!='@'){
                name++;
            }
            if(!domainNameDone||nameDone&&string.charAt(i)!='.'){
                domainName++;
            }
            if(nameDone&&string.charAt(i) =='.'){
                domainNameDone=true;
                dot++;
            }
            if(domainNameDone){
                domain++;
            }
        }
        
        if(name==0 || domainName==0||domain<2 || at>1 || at<1||dot>1||dot<1){
            return false;
        }else
            return true;
    }
}
