package com.echodemo.girl.web;

import com.echodemo.girl.bean.JsonResult;
import com.echodemo.girl.bean.User;
import com.echodemo.girl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @GetMapping(value = "/user/query/{id}")
    public ResponseEntity<JsonResult> getUserById(@PathVariable(value = "id") Integer id){
        JsonResult r = new JsonResult();
        try{
            User user = userService.getUserById(id);
            r.setResult(user);
            r.setStatus("ok");
        }catch (Exception e){
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping(value = "users")
    public ResponseEntity<JsonResult> getUserList(){
        JsonResult r = new JsonResult();
        try{
            List<User> users = userService.getUserList();
            r.setResult(users);
            r.setStatus("ok");
        }catch (Exception e){
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping(value = "/user/add")
    public ResponseEntity<JsonResult> add(@RequestBody User user){
        JsonResult r = new JsonResult();
        try {
            int orderId = userService.add(user);
            r.setResult(orderId);
            if (orderId < 0) {
                r.setStatus("fail");
            } else {
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping(value = "/user/delete/{id}")
    public ResponseEntity<JsonResult> delete(@PathVariable(value = "id") Integer id){
        JsonResult r = new JsonResult();
        try {
            int ret = userService.delete(id);
            r.setResult(ret);
            if (ret < 0) {
                r.setStatus("fail");
            } else {
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 更新用户
     * @param id
     * @param user
     * @return
     */
    @PutMapping(value = "/user/update/{id}")
    public ResponseEntity<JsonResult> update(@PathVariable("id") Integer id, @RequestBody User user){
        JsonResult r = new JsonResult();
        try {
            int ret = userService.update(id,user);
            r.setResult(ret);
            if (ret < 0) {
                r.setStatus("fail");
            } else {
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
