package com.dancestudioSpring.Facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.ViewModel.Branch.BranchEditViewModel;
import com.dancestudioSpring.ViewModel.Branch.BranchLiteViewModel;
import com.dancestudioSpring.Entity.Branch;
import com.dancestudioSpring.Service.BranchService;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@Component
public class BranchFacade {

	@Autowired
	BranchService branchService;
	
	public JsonAnswerStatus add(String name) {
		Branch branch = new Branch();
		branch.setName(name);
		
		branch = branchService.add(branch);
		if(branch == null)return new JsonAnswerStatus("error", "try_add");
		return new JsonAnswerStatus("success");
	}
	
	public JsonAnswerStatus updateByColumn(int id_of_branch, String name, String value) {

		Branch branch = branchService.findById(id_of_branch);
		if(branch == null)return new JsonAnswerStatus("error", "not_found");
		
        switch (name)
        {
            case "name":
            	branch.setName(value);
                break;
            case "description":
            	branch.setDescription(value);
                break;
            case "coordinates":
            	branch.setCoordinates(value);
                break;
            default:
                break;
        }
        
        return branchService.update(branch)
    		? new JsonAnswerStatus("success")
    		: new JsonAnswerStatus("error");
	}
	
	public JsonAnswerStatus deleteById(int id_of_branch) {
		return branchService.delete(id_of_branch)
			? new JsonAnswerStatus("success")
    		: new JsonAnswerStatus("error");
	}
	
	public ArrayList<BranchLiteViewModel> listAllLite() {
		
		List<Branch> branches = branchService.listAll();
		
		ArrayList<BranchLiteViewModel> branchLiteViewModels = new ArrayList<BranchLiteViewModel>();
		
		for(Branch branch : branches) {
			branchLiteViewModels.add(
				new BranchLiteViewModel(
					branch.getId(),
					branch.getName(),
					branch.getCoordinates()
				)
			);
		}

        JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
        jsonAnswerStatus.setBranchLiteViewModels(branchLiteViewModels);
        
		return branchLiteViewModels;
	}


    public BranchEditViewModel getEdit(int id)
    {
        Branch branch = branchService.findById(id);
        if (branch == null) return null;

        BranchEditViewModel branchEditViewModel = new BranchEditViewModel(
            branch.getId(),
            branch.getName(),
            branch.getDescription(),
            branch.getCoordinates()
        );

        return branchEditViewModel;
    }

    public BranchLiteViewModel getLiteById(int id)
    {
        Branch branch = branchService.findById(id);
        if (branch == null) return null;
        return new BranchLiteViewModel(branch.getId(), branch.getName(), branch.getCoordinates());
    }
}
