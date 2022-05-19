package com.dancestudioSpring.Facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.dancestudioSpring.Entity.Teacher;
import com.dancestudioSpring.Service.TeacherRateService;
import com.dancestudioSpring.Service.TeacherService;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
import com.dancestudioSpring.ViewModel.Teacher.TeacherEditViewModel;
import com.dancestudioSpring.ViewModel.Teacher.TeacherLiteViewModel;
import com.dancestudioSpring.ViewModel.TeacherRate.TeacherRateLiteViewModel;

@Component
public class TeacherFacade {

	
	@Autowired
	TeacherService teacherService;
	
	

	public List<TeacherLiteViewModel> listAllLite() {
		
		List<Teacher> teachers = teacherService.listAll();
		
		ArrayList<TeacherLiteViewModel> teacherLiteViewModels = new ArrayList<TeacherLiteViewModel>();
		
		for(Teacher teacher : teachers) {
			teacherLiteViewModels.add(
				new TeacherLiteViewModel(
					teacher.getId(),
					teacher.getName(),
					null,
					false
				)
			);
		}
		
		return teacherLiteViewModels;
	}
	
    public JsonAnswerStatus getEdit(int id_of_teacher)
    {
        Teacher teacher = teacherService.findById(id_of_teacher);
        if (teacher == null) return new JsonAnswerStatus("error", "not_found");

        TeacherRateFacade teacherRateFacade = new TeacherRateFacade();
        ArrayList<TeacherRateLiteViewModel> teacherRateLiteViewModels = teacherRateFacade.listAllLiteByIdOfTeacher(id_of_teacher);

        TeacherEditViewModel teacherEditViewModel = new TeacherEditViewModel(
            teacher.getId(),
            teacher.getName(),
            getPosterSrc(teacher.getId()),
            teacher.getStavka(),
            teacher.getStavkaPlus(),
            teacherRateLiteViewModels,
            teacher.getMinStudents(),
            teacher.getRaz(),
            teacher.getUsual(),
            teacher.getUnlim(),
            teacher.getProcent(),
            teacher.getPlusAfterStudents(),
            teacher.getPlusAfterSumma()
        );

        JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
        jsonAnswerStatus.setTeacherEditViewModel(teacherEditViewModel);
        
		return jsonAnswerStatus;
    }

    
    public JsonAnswerStatus update(int id_of_teacher, String name, String value, MultipartFile file) {
        Teacher teacher = teacherService.findById(id_of_teacher);
        if (teacher == null) return new JsonAnswerStatus("error", "not_found");

        if (name == "poster" && file != null)
        {

        } else if (name == "posterDelete")
        {
            //this.deletePoster(teacher.id);
        } else
        {
            switch (name)
            {
                case "name":
                	teacher.setName(value);
                    break;
                case "stavka":
                    teacher.setStavka(Integer.parseInt(value));
                    break;
                case "min_students":
                    teacher.setMinStudents(Integer.parseInt(value));
                    break;
                case "raz":
                    teacher.setRaz(Integer.parseInt(value));
                    break;
                case "usual":
                    teacher.setUsual(Integer.parseInt(value));
                    break;
                case "unlim":
                    teacher.setUnlim(Integer.parseInt(value));
                    break;
                case "stavka_plus":
                    teacher.setStavkaPlus(Integer.parseInt(value));
                    break;
                case "plus_after_students":
                    teacher.setPlusAfterStudents(Integer.parseInt(value));
                    break;
                case "plus_after_summa":
                    teacher.setPlusAfterSumma(Integer.parseInt(value));
                    break;
                case "procent":
                    int procent = Integer.parseInt(value);
                    teacher.setProcent(procent > 100 || procent < 0 ? 0 : procent);
                    break;
                default:
                    break;
            }
            teacherService.update(teacher);
        }

        return new JsonAnswerStatus("success", null);
    }
    
    
    public JsonAnswerStatus add(String name)
    {
    	Teacher teacher = new Teacher();
    	teacher.setName(name);
    	
    	teacher = teacherService.add(teacher);
    	if(teacher == null)return new JsonAnswerStatus("error");

		return new JsonAnswerStatus("success", null);
    }
    
    public TeacherLiteViewModel getLiteById(int id_of_teacher) {
    	Teacher teacher = teacherService.findById(id_of_teacher);
    	if(teacher == null)return null;
    	return new TeacherLiteViewModel(
			teacher.getId(),
			teacher.getName(),
			this.getPosterSrc(id_of_teacher)
		);
    }
    
    public boolean delete(int id_of_teacher) {
    	Teacher teacher = teacherService.findById(id_of_teacher);
    	if(teacher == null)return false;
    	
    	//удаление ставок
    	TeacherRateService teacherRateService = new TeacherRateService();
    	teacherRateService.deleteAllByIdOfTeacher(id_of_teacher);
    	
    	return teacherService.delete(teacher);
    }
    
    
    @SuppressWarnings("unused")
	private boolean uploadPoster(MultipartFile file, String name) {
    	return false;
    }

    public String getPosterSrc(int id)
    {
        return null;
    }

    @SuppressWarnings("unused")
    private void deletePoster(int id)
    {

    }
    
    /*
        private async Task<bool> uploadPoster(IFormFile file, string nameOfFile)
        {
            string path = Directory.GetCurrentDirectory();
            string uploadsForFiles = path + "\\wwwroot\\uploads\\teacher";
            if (!Directory.Exists(uploadsForFiles))
            {
                Directory.CreateDirectory(uploadsForFiles);
            }

            string pathwithfileName = uploadsForFiles + "\\" + nameOfFile + ".jpg";
            string pathwithTmpName = uploadsForFiles + "\\tmp.png";
            using (var fileStream = new FileStream(pathwithTmpName, FileMode.Create))
            {
                await file.CopyToAsync(fileStream);

                fileStream.Dispose();
            }

            ResizeImageComponent resizeImageComponent = new ResizeImageComponent();
            resizeImageComponent.ResizeTmpImageAndSaveFinally_box(pathwithTmpName, pathwithfileName);

            if (File.Exists(pathwithTmpName)) File.Delete(pathwithTmpName);

            return true;
        }


        public string getPosterSrc(int id)
        {
            string folderPath = Directory.GetCurrentDirectory() + "\\wwwroot\\uploads\\teacher\\" + id.ToString() + ".jpg";
            if (File.Exists(folderPath))
            {
                return "/uploads/teacher/" + id.ToString() + ".jpg";
            }
            return null;
        }

        private void deletePoster(int id)
        {
            string path = Directory.GetCurrentDirectory();
            string filePath = path + "\\wwwroot\\uploads\\teacher\\" + id.ToString() + ".jpg";
            if (File.Exists(filePath))
            {
                File.Delete(filePath);
            }
        }
    */
}
