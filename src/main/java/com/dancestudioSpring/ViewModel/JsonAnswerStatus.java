package com.dancestudioSpring.ViewModel;

import java.util.ArrayList;
import java.util.List;

import com.dancestudioSpring.ViewModel.TeacherReplacement.TeacherReplacementStatusViewModel;
import com.dancestudioSpring.ViewModel.PurchaseAbonement.PurchaseAbonementStatistikLiteViewModel;
import com.dancestudioSpring.ViewModel.Abonement.AbonementEditViewModel;
import com.dancestudioSpring.ViewModel.Abonement.AbonementForBuyingViewModel;
import com.dancestudioSpring.ViewModel.Abonement.AbonementLiteViewModel;
import com.dancestudioSpring.ViewModel.Abonement.AbonementLiteWithPrivateConnectionToUserViewModel;
import com.dancestudioSpring.ViewModel.Abonement.AbonementsBySpecialStatusViewModel;
import com.dancestudioSpring.ViewModel.Admin.AdminProfileViewModel;
import com.dancestudioSpring.ViewModel.Branch.BranchEditViewModel;
import com.dancestudioSpring.ViewModel.Branch.BranchLiteViewModel;
import com.dancestudioSpring.ViewModel.DanceGroup.DanceGroupByDanceGroupDayOfWeekLiteViewModel;
import com.dancestudioSpring.ViewModel.DanceGroup.DanceGroupConnectionToUserAdminViewModel;
import com.dancestudioSpring.ViewModel.DanceGroup.DanceGroupEditViewModel;
import com.dancestudioSpring.ViewModel.DanceGroup.DanceGroupLiteViewModel;
import com.dancestudioSpring.ViewModel.DanceGroup.DanceGroupScheduleViewModel;
import com.dancestudioSpring.ViewModel.DanceGroup.DanceGroupScheduleWithNameOfDayOfWeek;
import com.dancestudioSpring.ViewModel.DanceGroupCansel.DanceGroupCanselLiteViewModel;
import com.dancestudioSpring.ViewModel.Discount.DiscountWithConnectionToUserLiteViewModel;
import com.dancestudioSpring.ViewModel.PurchaseAbonement.PurchaseAbonementEditViewModel;
import com.dancestudioSpring.ViewModel.PurchaseAbonement.PurchaseAbonementLiteViewModel;
import com.dancestudioSpring.ViewModel.Teacher.TeacherEditViewModel;
import com.dancestudioSpring.ViewModel.User.UserProfileViewModel;
import com.dancestudioSpring.ViewModel.User.UserSearchPreviewViewModel;
import com.dancestudioSpring.ViewModel.Visit.VisitLessonsByDateViewModel;
import com.dancestudioSpring.ViewModel.Visit.VisitLiteViewModel;
import com.dancestudioSpring.ViewModel.Visit.VisitPrepareViewModel;
import com.dancestudioSpring.ViewModel.Visit.VisitStatisticLiteViewModel;

public class JsonAnswerStatus {

	private String status;
	private String errors;
	private String accessToken;
	private AdminProfileViewModel adminProfileViewModel;
	
	private ArrayList<BranchLiteViewModel> branchLiteViewModels;
	private BranchEditViewModel branchEditViewModel;
	
	private TeacherEditViewModel teacherEditViewModel;
	private TeacherReplacementStatusViewModel teacherReplacementStatusViewModel;
	
	private UserProfileViewModel userProfileViewModel;
	private ArrayList<UserSearchPreviewViewModel> userSearchPreviewViewModels;
	private int usersSearchCount;
	
	private List<DanceGroupLiteViewModel> danceGroupLiteViewModels;
	private List<DanceGroupCanselLiteViewModel> danceGroupCanselLiteViewModels;
	
	private ArrayList<AbonementLiteViewModel> abonementLiteViewModels;
	private AbonementEditViewModel abonementEditViewModel;
	private AbonementsBySpecialStatusViewModel abonementsBySpecialStatusViewModel;
	private AbonementForBuyingViewModel abonementForBuyingViewModel;
	
	private ArrayList<AbonementLiteWithPrivateConnectionToUserViewModel> abonementLiteWithPrivateConnectionToUserViewModels;
	
	private ArrayList<DiscountWithConnectionToUserLiteViewModel> discountWithConnectionToUserLiteViewModels;
	
	private PurchaseAbonementLiteViewModel purchaseAbonementLiteViewModel;
	private PurchaseAbonementEditViewModel purchaseAbonementEditViewModel;
	private PurchaseAbonementStatistikLiteViewModel purchaseAbonementStatistikLiteViewModel;
	private ArrayList<PurchaseAbonementLiteViewModel> purchaseAbonementLiteViewModels;
	private ArrayList<PurchaseAbonementEditViewModel> purchaseAbonementEditViewModels;
	
	private ArrayList<DanceGroupConnectionToUserAdminViewModel> danceGroupConnectionToUserAdminViewModels;
	
	private DanceGroupScheduleWithNameOfDayOfWeek danceGroupScheduleWithNameOfDayOfWeek;
	private DanceGroupScheduleViewModel danceGroupScheduleViewModel;
	private ArrayList<DanceGroupByDanceGroupDayOfWeekLiteViewModel> danceGroupByDanceGroupDayOfWeekLiteViewModels;
	private DanceGroupEditViewModel danceGroupEditViewModel;
	
	private ArrayList<VisitLiteViewModel> visitLiteViewModels;
	private VisitLiteViewModel visitLiteViewModel;
	private VisitPrepareViewModel visitPrepareViewModel;
	private VisitLessonsByDateViewModel visitLessonsByDateViewModel;
	
	private VisitStatisticLiteViewModel visitStatisticLiteViewModel;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}

	public static JsonAnswerStatus noData() {
		JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus();
		jsonAnswerStatus.setStatus("errors");
		jsonAnswerStatus.setErrors("no_data");
		return jsonAnswerStatus;
	}
	
	
	
	//@SuppressWarnings("unused")
	private JsonAnswerStatus() {super();}
	
	public JsonAnswerStatus(String status) {
		super();
		this.status = status;
	}
	public JsonAnswerStatus(String status, String errors) {
		super();
		this.status = status;
		this.errors = errors;
	}
	
	
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public JsonAnswerStatus(String status, String errors, String accessToken) {
		super();
		this.status = status;
		this.errors = errors;
		this.accessToken = accessToken;
	}
	
	
	
	public AdminProfileViewModel getAdminProfileViewModel() {
		return adminProfileViewModel;
	}
	public void setAdminProfileViewModel(AdminProfileViewModel adminProfileViewModel) {
		this.adminProfileViewModel = adminProfileViewModel;
	}
	
	
	public ArrayList<BranchLiteViewModel> getBranchLiteViewModels() {
		return branchLiteViewModels;
	}
	public void setBranchLiteViewModels(ArrayList<BranchLiteViewModel> branchLiteViewModels) {
		this.branchLiteViewModels = branchLiteViewModels;
	}
	public BranchEditViewModel getBranchEditViewModel() {
		return branchEditViewModel;
	}
	public void setBranchEditViewModel(BranchEditViewModel branchEditViewModel) {
		this.branchEditViewModel = branchEditViewModel;
	}
	
	
	
	public TeacherEditViewModel getTeacherEditViewModel() {
		return teacherEditViewModel;
	}
	public void setTeacherEditViewModel(TeacherEditViewModel teacherEditViewModel) {
		this.teacherEditViewModel = teacherEditViewModel;
	}
	public TeacherReplacementStatusViewModel getTeacherReplacementStatusViewModel() {
		return teacherReplacementStatusViewModel;
	}
	public void setTeacherReplacementStatusViewModel(TeacherReplacementStatusViewModel teacherReplacementStatusViewModel) {
		this.teacherReplacementStatusViewModel = teacherReplacementStatusViewModel;
	}
	
	
	
	public UserProfileViewModel getUserProfileViewModel() {
		return userProfileViewModel;
	}
	public void setUserProfileViewModel(UserProfileViewModel userProfileViewModel) {
		this.userProfileViewModel = userProfileViewModel;
	}
	
	
	public ArrayList<UserSearchPreviewViewModel> getUserSearchPreviewViewModels() {
		return userSearchPreviewViewModels;
	}
	public void setUserSearchPreviewViewModels(ArrayList<UserSearchPreviewViewModel> userSearchPreviewViewModels) {
		this.userSearchPreviewViewModels = userSearchPreviewViewModels;
	}
	public int getUsersSearchCount() {
		return usersSearchCount;
	}
	public void setUsersSearchCount(int usersSearchCount) {
		this.usersSearchCount = usersSearchCount;
	}
	
	
	
	
	
	public List<DanceGroupLiteViewModel> getDanceGroupLiteViewModels() {
		return danceGroupLiteViewModels;
	}
	public void setDanceGroupLiteViewModels(List<DanceGroupLiteViewModel> danceGroupLiteViewModels) {
		this.danceGroupLiteViewModels = danceGroupLiteViewModels;
	}
	public List<DanceGroupCanselLiteViewModel> getDanceGroupCanselLiteViewModels() {
		return danceGroupCanselLiteViewModels;
	}
	public void setDanceGroupCanselLiteViewModels(List<DanceGroupCanselLiteViewModel> danceGroupCanselLiteViewModels) {
		this.danceGroupCanselLiteViewModels = danceGroupCanselLiteViewModels;
	}
	
	
	
	
	
	
	
	public ArrayList<AbonementLiteViewModel> getAbonementLiteViewModels() {
		return abonementLiteViewModels;
	}
	public void setAbonementLiteViewModels(ArrayList<AbonementLiteViewModel> abonementLiteViewModels) {
		this.abonementLiteViewModels = abonementLiteViewModels;
	}
	public AbonementEditViewModel getAbonementEditViewModel() {
		return abonementEditViewModel;
	}
	public void setAbonementEditViewModel(AbonementEditViewModel abonementEditViewModel) {
		this.abonementEditViewModel = abonementEditViewModel;
	}
	public AbonementsBySpecialStatusViewModel getAbonementsBySpecialStatusViewModel() {
		return abonementsBySpecialStatusViewModel;
	}
	public void setAbonementsBySpecialStatusViewModel(
			AbonementsBySpecialStatusViewModel abonementsBySpecialStatusViewModel) {
		this.abonementsBySpecialStatusViewModel = abonementsBySpecialStatusViewModel;
	}
	public AbonementForBuyingViewModel getAbonementForBuyingViewModel() {
		return abonementForBuyingViewModel;
	}
	public void setAbonementForBuyingViewModel(AbonementForBuyingViewModel abonementForBuyingViewModel) {
		this.abonementForBuyingViewModel = abonementForBuyingViewModel;
	}
	
	
	
	
	
	public ArrayList<AbonementLiteWithPrivateConnectionToUserViewModel> getAbonementLiteWithPrivateConnectionToUserViewModels() {
		return abonementLiteWithPrivateConnectionToUserViewModels;
	}
	public void setAbonementLiteWithPrivateConnectionToUserViewModels(
			ArrayList<AbonementLiteWithPrivateConnectionToUserViewModel> abonementLiteWithPrivateConnectionToUserViewModels) {
		this.abonementLiteWithPrivateConnectionToUserViewModels = abonementLiteWithPrivateConnectionToUserViewModels;
	}
	public ArrayList<DiscountWithConnectionToUserLiteViewModel> getDiscountWithConnectionToUserLiteViewModels() {
		return discountWithConnectionToUserLiteViewModels;
	}
	public void setDiscountWithConnectionToUserLiteViewModels(
			ArrayList<DiscountWithConnectionToUserLiteViewModel> discountWithConnectionToUserLiteViewModels) {
		this.discountWithConnectionToUserLiteViewModels = discountWithConnectionToUserLiteViewModels;
	}
	
	
	
	public PurchaseAbonementLiteViewModel getPurchaseAbonementLiteViewModel() {
		return purchaseAbonementLiteViewModel;
	}
	public void setPurchaseAbonementLiteViewModel(PurchaseAbonementLiteViewModel purchaseAbonementLiteViewModel) {
		this.purchaseAbonementLiteViewModel = purchaseAbonementLiteViewModel;
	}
	public PurchaseAbonementEditViewModel getPurchaseAbonementEditViewModel() {
		return purchaseAbonementEditViewModel;
	}
	public void setPurchaseAbonementEditViewModel(PurchaseAbonementEditViewModel purchaseAbonementEditViewModel) {
		this.purchaseAbonementEditViewModel = purchaseAbonementEditViewModel;
	}
	public PurchaseAbonementStatistikLiteViewModel getPurchaseAbonementStatistikLiteViewModel() {
		return purchaseAbonementStatistikLiteViewModel;
	}
	public void setPurchaseAbonementStatistikLiteViewModel(
			PurchaseAbonementStatistikLiteViewModel purchaseAbonementStatistikLiteViewModel) {
		this.purchaseAbonementStatistikLiteViewModel = purchaseAbonementStatistikLiteViewModel;
	}
	public ArrayList<PurchaseAbonementLiteViewModel> getPurchaseAbonementLiteViewModels() {
		return purchaseAbonementLiteViewModels;
	}
	public void setPurchaseAbonementLiteViewModels(
			ArrayList<PurchaseAbonementLiteViewModel> purchaseAbonementLiteViewModels) {
		this.purchaseAbonementLiteViewModels = purchaseAbonementLiteViewModels;
	}
	public ArrayList<PurchaseAbonementEditViewModel> getPurchaseAbonementEditViewModels() {
		return purchaseAbonementEditViewModels;
	}
	public void setPurchaseAbonementEditViewModels(
			ArrayList<PurchaseAbonementEditViewModel> purchaseAbonementEditViewModels) {
		this.purchaseAbonementEditViewModels = purchaseAbonementEditViewModels;
	}
	
	
	public ArrayList<DanceGroupConnectionToUserAdminViewModel> getDanceGroupConnectionToUserAdminViewModels() {
		return danceGroupConnectionToUserAdminViewModels;
	}
	public void setDanceGroupConnectionToUserAdminViewModels(
			ArrayList<DanceGroupConnectionToUserAdminViewModel> danceGroupConnectionToUserAdminViewModels) {
		this.danceGroupConnectionToUserAdminViewModels = danceGroupConnectionToUserAdminViewModels;
	}
	
	
	
	
	public DanceGroupScheduleWithNameOfDayOfWeek getDanceGroupScheduleWithNameOfDayOfWeek() {
		return danceGroupScheduleWithNameOfDayOfWeek;
	}
	public void setDanceGroupScheduleWithNameOfDayOfWeek(
			DanceGroupScheduleWithNameOfDayOfWeek danceGroupScheduleWithNameOfDayOfWeek) {
		this.danceGroupScheduleWithNameOfDayOfWeek = danceGroupScheduleWithNameOfDayOfWeek;
	}
	public DanceGroupScheduleViewModel getDanceGroupScheduleViewModel() {
		return danceGroupScheduleViewModel;
	}
	public void setDanceGroupScheduleViewModel(DanceGroupScheduleViewModel danceGroupScheduleViewModel) {
		this.danceGroupScheduleViewModel = danceGroupScheduleViewModel;
	}
	public ArrayList<DanceGroupByDanceGroupDayOfWeekLiteViewModel> getDanceGroupByDanceGroupDayOfWeekLiteViewModels() {
		return danceGroupByDanceGroupDayOfWeekLiteViewModels;
	}
	public void setDanceGroupByDanceGroupDayOfWeekLiteViewModels(
			ArrayList<DanceGroupByDanceGroupDayOfWeekLiteViewModel> danceGroupByDanceGroupDayOfWeekLiteViewModels) {
		this.danceGroupByDanceGroupDayOfWeekLiteViewModels = danceGroupByDanceGroupDayOfWeekLiteViewModels;
	}
	public DanceGroupEditViewModel getDanceGroupEditViewModel() {
		return danceGroupEditViewModel;
	}
	public void setDanceGroupEditViewModel(DanceGroupEditViewModel danceGroupEditViewModel) {
		this.danceGroupEditViewModel = danceGroupEditViewModel;
	}
	
	
	
	public ArrayList<VisitLiteViewModel> getVisitLiteViewModels() {
		return visitLiteViewModels;
	}
	public void setVisitLiteViewModels(ArrayList<VisitLiteViewModel> visitLiteViewModels) {
		this.visitLiteViewModels = visitLiteViewModels;
	}
	
	public VisitLiteViewModel getVisitLiteViewModel() {
		return visitLiteViewModel;
	}
	public void setVisitLiteViewModel(VisitLiteViewModel visitLiteViewModel) {
		this.visitLiteViewModel = visitLiteViewModel;
	}
	public VisitPrepareViewModel getVisitPrepareViewModel() {
		return visitPrepareViewModel;
	}
	public void setVisitPrepareViewModel(VisitPrepareViewModel visitPrepareViewModel) {
		this.visitPrepareViewModel = visitPrepareViewModel;
	}
	
	public VisitLessonsByDateViewModel getVisitLessonsByDateViewModel() {
		return visitLessonsByDateViewModel;
	}
	public void setVisitLessonsByDateViewModel(VisitLessonsByDateViewModel visitLessonsByDateViewModel) {
		this.visitLessonsByDateViewModel = visitLessonsByDateViewModel;
	}
	
	
	
	
	
	public VisitStatisticLiteViewModel getVisitStatisticLiteViewModel() {
		return visitStatisticLiteViewModel;
	}
	public void setVisitStatisticLiteViewModel(VisitStatisticLiteViewModel visitStatisticLiteViewModel) {
		this.visitStatisticLiteViewModel = visitStatisticLiteViewModel;
	}
	
	
	
	
	
	
}
