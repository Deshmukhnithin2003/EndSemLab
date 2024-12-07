
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/updateDepartment")
    public String updateDepartment(
        @RequestParam int departmentId,
        @RequestParam String name,
        @RequestParam String location
    ) {
        boolean isUpdated = departmentService.updateDepartment(departmentId, name, location);
        return isUpdated ? "Department updated successfully!" : "Department not found!";
    }
}
