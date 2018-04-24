var app = angular.module('myApp', []);
app.controller('checkAmountController', function($scope, $http, $window) {
	
	var apiUrlOfCheckAmount = "../checkAmount/dev.do";
	
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
		apiUrlOfCheckAmount = "../checkAmount/dev.do";
		$('#checkAmountRes').val('');

	});
	$('#staging-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#dev-lotto-form-link').removeClass('active');
		$('#prod-lotto-form-link').removeClass('active');
		apiUrlOfCheckAmount = "../checkAmount/staging.do";
		$('#checkAmountRes').val('');

	});
	$('#prod-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#dev-lotto-form-link').removeClass('active');
		$('#staging-lotto-form-link').removeClass('active');
		apiUrlOfCheckAmount = "../checkAmount/prod.do";
		$('#checkAmountRes').val('');

	});
	
	$scope.submitCheckAmount = function() {
		$('#submitCheckAmount').attr('disabled','disabled');
		var checkAmountReq = $scope.checkAmountReq;
		checkAmountReq.kenoOrIlotto = $scope.keno_channel;
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : apiUrlOfCheckAmount + '?kenoOrIlotto=' + $scope.keno_channel,
//			url : apiUrlOfCheckAmount,
			data : checkAmountReq
		}).then(function mySuccess(response) {
			console.log('success');
			console.log(response.data);
			$scope.checkAmountRes = JSON.stringify(response.data);
			$('#submitCheckAmount').removeAttr('disabled');
		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			$('#submitCheckAmount').removeAttr('disabled');
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