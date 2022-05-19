package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.Branch.BranchEditByColumnDTO;
import com.dancestudioSpring.DTO.Branch.BranchIdDTO;
import com.dancestudioSpring.DTO.Branch.BranchNewDTO;
import com.dancestudioSpring.Facade.BranchFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
public class ApiBranchController {

	@Autowired
	BranchFacade branchFacade;

	@PostMapping("/api/branch/add")
	public JsonAnswerStatus add(BranchNewDTO branchNewDTO) {
		return branchFacade.add(branchNewDTO.getName());
	}

	@PostMapping("/api/branch/update")
	public JsonAnswerStatus update(BranchEditByColumnDTO branchEditByColumnDTO) {
		return branchFacade.updateByColumn(
				branchEditByColumnDTO.getId_of_branch(),
				branchEditByColumnDTO.getName(),
				branchEditByColumnDTO.getValue()
		);
	}

	@PostMapping("/api/branch/delete")
	public JsonAnswerStatus delete(BranchIdDTO branchIdDTO) {
		return branchFacade.deleteById(branchIdDTO.getId_of_branch());
	}
	
	
	@PostMapping("/api/branch/list_all_lite")
	public JsonAnswerStatus listAll() {
		JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
		jsonAnswerStatus.setBranchLiteViewModels(branchFacade.listAllLite());
		return jsonAnswerStatus;
	}

	@PostMapping("api/get_edit")
    public JsonAnswerStatus getEdit(BranchIdDTO branchIdDTO)
    {
		JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
		jsonAnswerStatus.setBranchEditViewModel(branchFacade.getEdit(branchIdDTO.getId_of_branch()));
        return jsonAnswerStatus;
    }
}
