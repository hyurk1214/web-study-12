package kr.ac.dju.controller;

import kr.ac.dju.controller.action.Action;
import kr.ac.dju.controller.action.BookDeleteAction;
import kr.ac.dju.controller.action.BookDeleteFormAction;
import kr.ac.dju.controller.action.BookList2Action;
import kr.ac.dju.controller.action.BookListAction;
import kr.ac.dju.controller.action.BookSearchForm;
import kr.ac.dju.controller.action.BookUpdateAction;
import kr.ac.dju.controller.action.BookUpdateFormAction;
import kr.ac.dju.controller.action.BookViewAction;
import kr.ac.dju.controller.action.BookWriteAction;
import kr.ac.dju.controller.action.BookWriteFormAction;
import kr.ac.dju.controller.action.JoinAction;
import kr.ac.dju.controller.action.JoinFormAction;
import kr.ac.dju.controller.action.loginAction;
import kr.ac.dju.controller.action.loginFormAction;

public class ActionFactory{
  
    private static ActionFactory instance = new ActionFactory();
    
    private ActionFactory() {
      super();
    }
    
    public static ActionFactory getInstance() {
      return instance;
    }
    
    public Action getAction(String command) {
      Action action = null;
      
      System.out.println("ActionFactory : " + command);
      
      if(command.equals("book_list")) {
        action = new BookListAction();
      }
      else if(command.equals("book_view")) {
        action = new BookViewAction();
      }
      else if(command.equals("book_write_form")) {
        action = new BookWriteFormAction();
      }
      else if(command.equals("book_write")) {
        action = new BookWriteAction();
      }
      else if(command.equals("book_update_form")) {
        action = new BookUpdateFormAction();
      }
      else if(command.equals("book_update")) {
        action = new BookUpdateAction();
      }
      else if(command.equals("book_search_form")){
        action = new BookSearchForm();
      }
      else if(command.equals("book_delete_form")) {
        action = new BookDeleteFormAction();
      }
      else if(command.equals("book_delete")) {
        action = new BookDeleteAction();
      }
      else if ( command.equals("book_join_form")) {
        action = new JoinFormAction();
      }
      else if ( command.equals("book_join")) {
        action = new JoinAction();
      }
      else if (command.equals("book_login_form")) {
        action = new loginFormAction();
      }
      else if (command.equals("book_login")) {
        action = new loginAction();
      }
      else if(command.equals("book_List2")) {
        action = new BookList2Action();
      }
      return action;
    }
  }