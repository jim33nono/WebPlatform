var app = angular.module('myApp', []);
app.controller('getBetHistoryController', function($scope, $http, $window) {

	var apiUrlOfGetBetHistory = "../getBetHistory/dev.do";

	$('#keno-channel').click(function(e) {
		$(this).addClass('active');
		$('#ilotto-channel').removeClass('active');
		$('#getBetHistoryRes').val('');
		$scope.keno_channel = true;
		$scope.ilotto_channel = false;

	});

	$('#ilotto-channel').click(function(e) {
		$(this).addClass('active');
		$('#keno-channel').removeClass('active');
		$('#getBetHistoryRes').val('');
		$scope.keno_channel = false;
		$scope.ilotto_channel = true;

	});

	$('#dev-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#staging-lotto-form-link').removeClass('active');
		$('#prod-lotto-form-link').removeClass('active');
		apiUrlOfGetBetHistory = "../getBetHistory/dev.do";
		$('#getBetHistoryRes').val('');
		// $('#merchantCodeOfBetHisReq').val('SGTEST');
		// $scope.getBetHistoryReq.merchantCode = 'SGTEST';
		$('#merchantCodeOfBetHisReq').prop('readonly', false);

	});
	$('#staging-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#dev-lotto-form-link').removeClass('active');
		$('#prod-lotto-form-link').removeClass('active');
		apiUrlOfGetBetHistory = "../getBetHistory/staging.do";
		$('#getBetHistoryRes').val('');
		// $('#merchantCodeOfBetHisReq').val('SGTEST');
		// $scope.getBetHistoryReq.merchantCode = 'SGTEST';
		$('#merchantCodeOfBetHisReq').prop('readonly', false);

	});
	$('#prod-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#dev-lotto-form-link').removeClass('active');
		$('#staging-lotto-form-link').removeClass('active');
		apiUrlOfGetBetHistory = "../getBetHistory/prod.do";
		$('#getBetHistoryRes').val('');
		// $('#merchantCodeOfBetHisReq').val('TEST');
		// $scope.getBetHistoryReq.merchantCode = 'TEST';
		$('#merchantCodeOfBetHisReq').prop('readonly', false);

	});

	$scope.submitGetBetHis = function() {
		$('#submitGetBetHis').attr('disabled', 'disabled');
		var getBetHistoryReq = $scope.getBetHistoryReq;
		getBetHistoryReq.kenoOrIlotto = $scope.keno_channel;
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : apiUrlOfGetBetHistory,
			data : getBetHistoryReq
		}).then(function mySuccess(response) {
			console.log('success');
			console.log(response.data);
			$scope.getBetHistoryRes = JSON.stringify(response.data);
			$('#submitGetBetHis').removeAttr('disabled');
		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			$('#submitGetBetHis').removeAttr('disabled');
		});

	};

	$('.form_datetime').datetimepicker({
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		forceParse : 0
	});
	
});