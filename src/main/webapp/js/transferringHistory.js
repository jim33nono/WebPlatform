var app = angular.module('myApp', []);
app.controller('transferringHistory', function($scope, $http, $window) {
	showGatewaySwitchList();

});

function showGatewaySwitchList() {
	$('#transferringHistory').bootstrapTable({
		url : '../oneWallet/loadingHistory.do',
		columns : [ {
			field : 'txId',
			title : 'Transaction:',
			halign : 'left'
		}, {
			field : 'transferId',
			title : 'Transfer ID:',
			halign : 'left'
		}, {
			field : 'ticketId',
			title : 'Ticket ID:',
			halign : 'left'
		}, {
			field : 'acctId',
			title : 'Acct ID:',
			halign : 'left'
		}, {
			field : 'amount',
			title : 'Amount:',
			halign : 'left'
		}, {
			field : 'transferType',
			title : 'Type:',
			halign : 'left'
		}, {
			field : 'operationTime',
			title : 'Time:',
			halign : 'left'
		} ]

	});

}

function typeFormatter(data) {
	if (data == '1') {
		return `${data} - place bet`;
	} else if (data == '2') {
		return `${data} - cancel bet`;
	} else if (data == '4') {
		return `${data} - payout`;
	} else if (data == '5') {
		return `${data} - cancel payout`;
	} else {
		return null;
	}
}

function dateFormatter(data) {
	var date = new Date(data);
	return date.toLocaleString();
}

