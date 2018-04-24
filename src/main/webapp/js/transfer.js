var app = angular.module('myApp', []);
app.controller('transferCtrl', function($scope, $http, $window) {

	var apiUrlOfDeposit = "../transfering/dev/deposit.do";
	var apiUrlOfWithdraw = "../transfering/dev/withdraw.do";
	var recaptchaToken = "";

	$('#keno-channel').click(function(e) {
		$(this).addClass('active');
		$('#ilotto-channel').removeClass('active');
		$('#depositResponse').val('');
		$('#withdrawResponse').val('');
		$scope.keno_channel = true;
		$scope.ilotto_channel = false;

	});

	$('#ilotto-channel').click(function(e) {
		$(this).addClass('active');
		$('#keno-channel').removeClass('active');
		$('#depositResponse').val('');
		$('#withdrawResponse').val('');
		$scope.keno_channel = false;
		$scope.ilotto_channel = true;

	});

	$('#dev-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#staging-lotto-form-link').removeClass('active');
		$('#prod-lotto-form-link').removeClass('active');
		apiUrlOfDeposit = "../transfering/dev/deposit.do";
		apiUrlOfWithdraw = "../transfering/dev/withdraw.do";
		$('#depositResponse').val('');
		$('#withdrawResponse').val('');

		// $('#merchantCodeWithdraw').prop('readonly', false);
		// $('#merchantCodeDeposit').prop('readonly', false);

	});
	$('#staging-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#dev-lotto-form-link').removeClass('active');
		$('#prod-lotto-form-link').removeClass('active');
		apiUrlOfDeposit = "../transfering/staging/deposit.do";
		apiUrlOfWithdraw = "../transfering/staging/withdraw.do";
		$('#depositResponse').val('');
		$('#withdrawResponse').val('');

		// $('#merchantCodeWithdraw').prop('readonly', false);
		// $('#merchantCodeDeposit').prop('readonly', false);

	});
	$('#prod-lotto-form-link').click(function(e) {
		$(this).addClass('active');
		$('#dev-lotto-form-link').removeClass('active');
		$('#staging-lotto-form-link').removeClass('active');
		apiUrlOfDeposit = "../transfering/prod/deposit.do";
		apiUrlOfWithdraw = "../transfering/prod/withdraw.do";
		$('#depositResponse').val('');
		$('#withdrawResponse').val('');

		// $('#merchantCodeWithdraw').prop('readonly', true);
		// $('#merchantCodeDeposit').prop('readonly', true);

	});

	$('#deposit-form-link').click(function(e) {
		$("#deposit-form").delay(100).fadeIn(100);
		$("#withdraw-form").fadeOut(100);
		$('#withdraw-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#withdraw-form-link').click(function(e) {
		$("#withdraw-form").delay(100).fadeIn(100);
		$("#deposit-form").fadeOut(100);
		$('#deposit-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

	function checkRecaptcha(data) {
		$('.recaptcha-hint').empty();
		recaptchaToken = data;
		console.log(recaptchaToken);
		if (recaptchaToken == '' || recaptchaToken == null) {
			$('.recaptcha-hint').text("Please tick up reCaptcha!").css('color',
					'red');
			return false;
		}
		return true;
	}

	$scope.submitDeposit = function() {
		var depositInfo = $scope.depositInfo;
		depositInfo.kenoOrIlotto = $scope.keno_channel;
		var hiddenRecaptcha = $('#deposit_hiddenRecaptcha').val();
		if (!checkRecaptcha(hiddenRecaptcha)) {
			return false;
		}
		$('#submitDeposit').attr('disabled', 'disabled');
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : apiUrlOfDeposit + "?token=" + hiddenRecaptcha,
			data : depositInfo
		}).then(function mySuccess(response) {
			console.log('success');
			$scope.depositResponse = JSON.stringify(response.data);
			$('#submitDeposit').removeAttr('disabled');
			grecaptcha.reset(widgetId1); // reload reCAPTCHA
		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			$('#submitDeposit').removeAttr('disabled');
			grecaptcha.reset(widgetId1)
		});

	};

	$scope.submitWithdraw = function() {
		var withdrawInfo = $scope.withdrawInfo;
		withdrawInfo.kenoOrIlotto = $scope.keno_channel;
		var hiddenRecaptcha = $('#withdraw_hiddenRecaptcha').val();
		if (!checkRecaptcha(hiddenRecaptcha)) {
			return false;
		}
		$('#submitWithdraw').attr('disabled', 'disabled');
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : apiUrlOfWithdraw + "?token=" + hiddenRecaptcha,
			data : withdrawInfo
		}).then(function mySuccess(response) {
			console.log('success');
			$scope.withdrawResponse = JSON.stringify(response.data);
			$('#submitWithdraw').removeAttr('disabled');
			grecaptcha.reset(widgetId2); // reload reCAPTCHA
		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			$('#submitWithdraw').removeAttr('disabled');
			grecaptcha.reset(widgetId2);
		});

	}

});

var widgetId1;
var widgetId2;

var captchaCallback = function() {
	widgetId1 = grecaptcha.render('recaptchaDeposit', {
		'sitekey' : '6LeoBE0UAAAAABH0uSz7E3-rCJ_AJZ1oqARen8u2',
		'callback' : despositRecaptRes
	});
	widgetId2 = grecaptcha.render('recaptchaWithdraw', {
		'sitekey' : '6LeoBE0UAAAAABH0uSz7E3-rCJ_AJZ1oqARen8u2',
		'callback' : withdrawRecaptRes
	});
};
var despositRecaptRes = function(response) {
	$("#deposit_hiddenRecaptcha").val(response);
};
var withdrawRecaptRes = function(response) {
	$("#withdraw_hiddenRecaptcha").val(response);
};
