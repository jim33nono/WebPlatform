var app = angular.module('myApp', []);
app.controller('mainCtrl', function($scope, $http, $window) {

	var trigger = $('.hamburger'), overlay = $('.overlay'), isClosed = false;

	trigger.click(function() {
		hamburger_cross();
	});

	function hamburger_cross() {
		if (isClosed == true) {
			overlay.hide();
			trigger.removeClass('is-open');
			trigger.addClass('is-closed');
			isClosed = false;
		} else {
			overlay.hide();
			trigger.removeClass('is-closed');
			trigger.addClass('is-open');
			isClosed = true;
		}
	}

	$('[data-toggle="offcanvas"]').click(function() {
		$('#wrapper').toggleClass('toggled');
	});

	function shrinkSideBar() {
		$('#wrapper').toggleClass('toggled');
		hamburger_cross();
	}
	
	function showLoading() {
		$('.loading').addClass('loader');
		overlay.show();
	}
	
	function hideLoading() {
		overlay.hide();
		$('.loading').removeClass('loader');
	}
	
	shrinkSideBar();

	$scope.defaultPage = function() {
		$("#contentFrame").attr("src", "html/defaultPage.html");
	}

	$scope.checkLottoProd = function() {
		showLoading();
//		shrinkSideBar();
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : "lotto/prod/authorization.do"
		}).then(function mySuccess(response) {
			if (response.data.url != 'urlError') {
				console.log('success');
				console.log(response.data);
				$("#contentFrame").attr("src", response.data.url);
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Success',
					message : response.data.url
				});
				hideLoading();
			} else {
				console.log('url error');
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Error Dialog',
					message : 'Please tracing web-platfrom logs'
				});
				hideLoading();
			}
		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			hideLoading();
		});
	}

	$scope.checkLottoStaging = function() {
		showLoading();
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : "lotto/staging/authorization.do"
		}).then(function mySuccess(response) {
			if (response.data.url != 'urlError') {
				console.log('success');
				console.log(response.data);
				$("#contentFrame").attr("src", response.data.url);
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Success',
					message : response.data.url
				});
				hideLoading();
			} else {
				console.log('url error');
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Error Dialog',
					message : 'Please tracing web-platfrom logs'
				});
				hideLoading();
			}
		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			hideLoading();

		});

	}

	$scope.checkLottoDev = function() {
		showLoading();
//		shrinkSideBar();
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : "lotto/dev/authorization.do"
		}).then(function mySuccess(response) {
			if (response.data.url != 'urlError') {
				console.log('success');
				console.log(response.data);
				$("#contentFrame").attr("src", response.data.url);
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Success',
					message : response.data.url
				});
				hideLoading();
			} else {
				console.log('url error');
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Error Dialog',
					message : 'Please tracing web-platfrom logs'
				});
				hideLoading();
			}
		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			hideLoading();

		});
	}

	$scope.checkKenoProd = function() {
		showLoading();
//		shrinkSideBar();
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : "keno/prod/authorization.do"
		}).then(function mySuccess(response) {
			if (response.data.url != 'urlError') {
				console.log('success');
				console.log(response.data);
				$("#contentFrame").attr("src", response.data.url);
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Success',
					message : response.data.url
				});
				hideLoading();
			} else {
				console.log('url error');
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Error Dialog',
					message : 'Please tracing web-platfrom logs'
				});
				hideLoading();
			}
		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			hideLoading();

		});
	}

	$scope.checkKenoStaging = function() {
		showLoading();
//		shrinkSideBar();
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : "keno/staging/authorization.do"
		}).then(function mySuccess(response) {
			if (response.data.url != 'urlError') {
				console.log('success');
				console.log(response.data);
				$("#contentFrame").attr("src", response.data.url);
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Success',
					message : response.data.url
				});
				hideLoading();
			} else {
				console.log('url error');
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Error Dialog',
					message : 'Please tracing web-platfrom logs'
				});
				hideLoading();
			}
		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			hideLoading();

		});

	}

	$scope.checkKenoDev = function() {
		showLoading();
//		shrinkSideBar();
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : "keno/dev/authorization.do"
		}).then(function mySuccess(response) {
			if (response.data.url != 'urlError') {
				console.log('success');
				console.log(response.data);
				$("#contentFrame").attr("src", response.data.url);
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Success',
					message : response.data.url
				});
				hideLoading();
			} else {
				console.log('url error');
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Error Dialog',
					message : 'Please tracing web-platfrom logs'
				});
				hideLoading();
			}

		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			hideLoading();

		});
	}
	
	
	$scope.oneWalletKenoStaging = function() {
		showLoading();
//		shrinkSideBar();
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : "keno/staging/onewallet.do"
		}).then(function mySuccess(response) {
			if (response.data.url != 'urlError') {
				console.log('success');
				console.log(response.data);
				$("#contentFrame").attr("src", response.data.url);
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Success',
					message : response.data.url
				});
				hideLoading();
			} else {
				console.log('url error');
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Error Dialog',
					message : 'Please tracing web-platfrom logs'
				});
				hideLoading();
			}
		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			hideLoading();

		});

	}
	
	$scope.oneWalletKenoDev = function() {
		showLoading();
//		shrinkSideBar();
		$http({
			method : "POST",
			headers : {
				'Content-type' : 'application/json'
			},
			url : "keno/dev/onewallet.do"
		}).then(function mySuccess(response) {
			if (response.data.url != 'urlError') {
				console.log('success');
				console.log(response.data);
				$("#contentFrame").attr("src", response.data.url);
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Success',
					message : response.data.url
				});
				hideLoading();
			} else {
				console.log('url error');
				BootstrapDialog.show({
					cssClass : 'login-dialog',
					title : 'Error Dialog',
					message : 'Please tracing web-platfrom logs'
				});
				hideLoading();
			}

		}, function myError(response) {
			console.log('error');
			console.log(response);
			BootstrapDialog.show({
				cssClass : 'login-dialog',
				title : 'Error Dialog',
				message : JSON.stringify(response)
			});
			hideLoading();

		});
	}

	$scope.transfer = function() {
		$("#contentFrame").attr("src", "html/transfer.html");
		hideLoading();
	}
	
	$scope.getAcctInfo = function() {
		$("#contentFrame").attr("src", "html/getAcctInfo.html");
		hideLoading();
	}
	
	$scope.getBetHistory = function() {
		$("#contentFrame").attr("src", "html/getBetHistory.html");
		hideLoading();
	}
	
	$scope.checkStatus = function() {
		$("#contentFrame").attr("src", "html/checkStatus.html");
		hideLoading();
	}
	
	$scope.getDrawResult = function() {
		$("#contentFrame").attr("src", "html/getDrawResult.html");
		hideLoading();
	}
	
	$scope.checkAmount = function() {
		$("#contentFrame").attr("src", "html/checkAmount.html");
		hideLoading();
	}
	
	$scope.transferHistory = function() {
		$("#contentFrame").attr("src", "html/transferringHistoryOneWallet.html");
		hideLoading();
	}
	

});