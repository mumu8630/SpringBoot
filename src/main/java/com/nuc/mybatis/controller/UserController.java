package com.nuc.mybatis.controller;

import com.nuc.mybatis.pojo.User;
import com.nuc.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author 86186
 * @createDate:2022/11/1
 * @since
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    User user;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    private Integer idToUpdate;

    @GetMapping("/insert")
    public  String insertPage(){
        return "/insert";
    }
    @PostMapping("/insertCommit")
    public String insertUser(User user){
        if(userService.insert(user)>0){
            return "success";
        }
        return  "error";
    }

    @GetMapping("/findOne")
    public String findOnePage(){
        return "findOne";
    }
    @PostMapping("/findOneCommit")
    public ModelAndView findOne(Integer id){
        ModelAndView mv = new ModelAndView();
        User user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("findOneWithId");
        return mv;
    }

    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<User> users = userService.findAll();
        mv.addObject("users",users);
        mv.setViewName("findAll");
        //MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        //mv.setView(jsonView);
        return mv;
    }

    @GetMapping("/delete")
    public String delete(){
        return "delete";
    }
    @PostMapping("/deleteCommit")
    public String deleteUser(Integer id){
        if (userService.delete(id)>0){
            return "success";
        }
        return "error";
    }

    @GetMapping("/update")
    public String updatePage(){
        return "update";
    }
    @PostMapping("/updateWithIdCommit")
    public String update(User user){
        user.setId(idToUpdate);
        if (userService.update(user)>0){
            return "success";
        }
        return "error";
    }
    @PostMapping("/updateWithId")
    public ModelAndView findOneToUpdate(Integer id){
        ModelAndView mv = new ModelAndView();
        User user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("updateById");
        idToUpdate =user.getId();
        return mv;
    }

    @GetMapping("/find")
    public String findPage(){
        return "find";
    }
    @PostMapping("/findCommit")
    public ModelAndView find( String user_name,String address){
        List<User> users = userService.findUsers(user_name, address);
        ModelAndView mv = new ModelAndView();
        mv.addObject("users" ,users);
        mv.setViewName("findAll");
        return mv;
    }


}
