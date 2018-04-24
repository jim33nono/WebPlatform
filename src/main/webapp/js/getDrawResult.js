var app = angular.module('myApp', []);
app.controller('getDrawResultController', function($scope, $http, $window) {
	
	var apiUrlOfGetDrawResult = "../getDrawResult/dev.do";
	
	$('#keno-channel').click(function(e) {
		$(this).addClass('active');
		$('#ilotto-channel').removeClass('active');
		$('#checkStatusRes').val('');
		$scope.keno_channel = true;
		$scope.ilotto_channel = false;
		$('#getDrawResultReqGameCode').val('KN');
		$scope.getDrawResultReq.gameCode = 'KN';
		$('#getDrawResultReqMarket').val('BJ');
		$scope.getDrawResultReq.market = 'BJ';

	});

	$('#ilotto-channel').click(function(e) {
		$(this).addClass('active');
		$('#keno-channel').removeClass('active');
		$('#checkStatusRes').val('');
		$scope.keno_channel = false;
		$scope.ilotto_channel = true;
		$('#getDrawResultReqGameCode').val('LT');
		$scope.getDrawResultReq.gameCode = 'LT';
		$('#getDrawResultReqMarket').val('CQ');
		$scope.getDrawResultReq.market = 'CQ';

	});
	
	$('#dev-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#staging-lotto-form-link').removeClass('active');
		$('#prod-lotto-form-link').removeClass('active');
		apiUrlOfGetDrawResult = "../getDrawResult/dev.do";
		$('#getDrawResultRes').val('');

	});
	$('#staging-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#dev-lotto-form-link').removeClass('active');
		$('#prod-lotto-form-link').removeClass('active');
		apiUrlOfGetDrawResult = "../getDrawResult/staging.do";
		$('#getDrawResultRes').val('');

	});
	$('#prod-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#dev-lotto-form-link').removeClass('active');
		$('#staging-lotto-form-link').removeClass('active');
		apiUrlOfGetDrawResult = "../getDrawResult/prod.do";
		$('#getDrawResultRes').val('');

	});
	
	$scope.submitGetDrawResult = function() {
		$('#submitGetDrawResultTop').attr('disabled','disabled');
		$('#submitGetDrawResultBottom').attr('disabled','disabled');
		var getDrawResultReq = $scope.getDrawResultReq;
		getDrawResultReq.kenoOrIlotto = $scope.keno_channel;
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : apiUrlOfGetDrawResult + '?kenoOrIlotto=' + $scope.keno_channel,
			data : getDrawResultReq
		}).then(function mySuccess(response) {
			console.log('success');
			console.log(response.data);
			$scope.getDrawResultRes = JSON.stringify(response.data);
			$('#submitGetDrawResultTop').removeAttr('disabled');
			$('#submitGetDrawResultBottom').removeAttr('disabled');
		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			$('#submitGetDrawResultTop').removeAttr('disabled');
			$('#submitGetDrawResultBottom').removeAttr('disabled');
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
	
	$('.form_date').datetimepicker({
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		startView: 2,
		minView: 2,
		forceParse : 0
	});
	
	

});