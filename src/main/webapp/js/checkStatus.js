var app = angular.module('myApp', []);
app.controller('checkStatusController', function($scope, $http, $window) {
	
	var apiUrlOfCheckStatus = "../checkStatus/dev.do";
	
	$('#keno-channel').click(function(e) {
		$(this).addClass('active');
		$('#ilotto-channel').removeClass('active');
		$('#checkStatusRes').val('');
		$scope.keno_channel = true;
		$scope.ilotto_channel = false;

	});

	$('#ilotto-channel').click(function(e) {
		$(this).addClass('active');
		$('#keno-channel').removeClass('active');
		$('#checkStatusRes').val('');
		$scope.keno_channel = false;
		$scope.ilotto_channel = true;

	});
	
	$('#dev-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#staging-lotto-form-link').removeClass('active');
		$('#prod-lotto-form-link').removeClass('active');
		apiUrlOfCheckStatus = "../checkStatus/dev.do";
		$('#checkStatusRes').val('');
		$('#merchantCodeOfCheckStatusReq').prop('readonly', false);

	});
	$('#staging-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#dev-lotto-form-link').removeClass('active');
		$('#prod-lotto-form-link').removeClass('active');
		apiUrlOfCheckStatus = "../checkStatus/staging.do";
		$('#checkStatusRes').val('');
		$('#merchantCodeOfCheckStatusReq').prop('readonly', false);

	});
	$('#prod-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#dev-lotto-form-link').removeClass('active');
		$('#staging-lotto-form-link').removeClass('active');
		apiUrlOfCheckStatus = "../checkStatus/prod.do";
		$('#checkStatusRes').val('');
		$('#merchantCodeOfCheckStatusReq').prop('readonly', false);

	});
	
	$scope.submitCheckStatus = function() {
		$('#submitCheckStatus').attr('disabled','disabled');
		var checkStatusReq = $scope.checkStatusReq;
		checkStatusReq.kenoOrIlotto = $scope.keno_channel;
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : apiUrlOfCheckStatus,
			data : checkStatusReq
		}).then(function mySuccess(response) {
			console.log('success');
			console.log(response.data);
			$scope.checkStatusRes = JSON.stringify(response.data);
			$('#submitCheckStatus').removeAttr('disabled');
		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			$('#submitCheckStatus').removeAttr('disabled');
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