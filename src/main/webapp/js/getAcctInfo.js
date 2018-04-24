var app = angular.module('myApp', []);
app.controller('getAcctInfoController', function($scope, $http, $window) {
	
	var apiUrlOfGetAcctInfo = "../getAcctInfo/dev.do";
	
	$('#keno-channel').click(function(e) {
		$(this).addClass('active');
		$('#ilotto-channel').removeClass('active');
		$('#getAcctInfoRes').val('');
		$scope.keno_channel = true;
		$scope.ilotto_channel = false;

	});

	$('#ilotto-channel').click(function(e) {
		$(this).addClass('active');
		$('#keno-channel').removeClass('active');
		$('#getAcctInfoRes').val('');
		$scope.keno_channel = false;
		$scope.ilotto_channel = true;

	});
	
	$('#dev-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#staging-lotto-form-link').removeClass('active');
		$('#prod-lotto-form-link').removeClass('active');
		apiUrlOfGetAcctInfo = "../getAcctInfo/dev.do";
		$('#getAcctInfoRes').val('');

	});
	$('#staging-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#dev-lotto-form-link').removeClass('active');
		$('#prod-lotto-form-link').removeClass('active');
		apiUrlOfGetAcctInfo = "../getAcctInfo/staging.do";
		$('#getAcctInfoRes').val('');

	});
	$('#prod-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#dev-lotto-form-link').removeClass('active');
		$('#staging-lotto-form-link').removeClass('active');
		apiUrlOfGetAcctInfo = "../getAcctInfo/prod.do";
		$('#getAcctInfoRes').val('');

	});
	
	$scope.submitGetAcct = function() {
		$('#submitGetAcct').attr('disabled','disabled');
		var acctInfoReq = $scope.acctInfoReq;
		acctInfoReq.kenoOrIlotto = $scope.keno_channel;
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : apiUrlOfGetAcctInfo,
			data : acctInfoReq
		}).then(function mySuccess(response) {
			console.log('success');
			console.log(response.data);
			$scope.getAcctInfoRes = JSON.stringify(response.data);
			$('#submitGetAcct').removeAttr('disabled');
		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			$('#submitGetAcct').removeAttr('disabled');
		});

	};
	
	

});