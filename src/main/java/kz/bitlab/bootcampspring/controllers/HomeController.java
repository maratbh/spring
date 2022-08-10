package kz.bitlab.bootcampspring.controllers;

import kz.bitlab.bootcampspring.model.Item;
import kz.bitlab.bootcampspring.model.Student;
import kz.bitlab.bootcampspring.util.DBStudent;
import kz.bitlab.bootcampspring.util.DBUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")  // @WebServlet(value = "/"), doGet(HttpServlerRequest request ...
    public String indexPage(Model model){

        ArrayList<Student> Students = DBStudent.getStudents();
        model.addAttribute("students", Students); // request.setAttribute("tovary", items);

        return "index"; // request.getRequestDispatcher("/index.html").forward(request, response);
    }

    @GetMapping(value = "/additem")
    public String addItem(Model model){
        return "additem";
    }

    @GetMapping(value = "/insertitem")
    public String insertItem(Model model){
        return "insertitem";
    }

    @PostMapping(value = "/additem") //@WebServlet(value = "/additem"), doPost()
    public String addItem(@RequestParam(name = "student_name") String name, // String name = request.getParameter("item_name");
                          @RequestParam(name = "student_surname") String surname, // double price = Double.parseDouble(request.getParameter("item_price"));
                          @RequestParam(name = "item_exam") int exam){

        Student st = new Student();
        st.setName(name);
        st.setSurname(surname);
        st.setExam(exam);
        DBStudent.addStudent(st);

        return "redirect:/"; // response.sendRedirect("/");
    }

    @GetMapping(value = "/details/{itemId}")
    public String details(@PathVariable(name = "itemId") Long id, Model model){
        Item item = DBUtil.getItem(id);
        model.addAttribute("tovar", item);
        return "details";
    }

    @GetMapping(value = "/details/{itemId}/{itemTag}.html")
    public String detailsWithHTML(@PathVariable(name = "itemId") Long id,
                                  @PathVariable(name = "itemTag") String tag,
                                  Model model){

       /* Item item = DBUtil.getItem(id);
        if(item!=null && !item.getTag().equals(tag)){
            return "redirect:/details/"+item.getId()+"/"+item.getTag()+".html";
        }
        model.addAttribute("tovar", item);*/
        return "details";
    }

    @PostMapping(value = "/toadditem") //@WebServlet(value = "/additem"), doPost()
    public String toAddItem(Student Student){
        DBStudent.addStudent(Student);
        return "redirect:/additem";
    }

}