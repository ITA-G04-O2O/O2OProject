Ext.define('commonController', {
    extend: 'Ext.app.Controller',

    init: function (application) {
        this.control({
            '#userBtn': {
                click: this.userPage
            },
            '#shopBtn': {
                click: this.shopPage
            },
            '#systemBtn': {
                click: this.systemPage
            },
            '#logo': {
                beforerender: this.loadLogo
            },
            '#title': {
                beforerender: this.loadSystemTitle
            }
        });
    },
    userPage: function () {
        window.location.href = 'userSearch.html';
    },
    shopPage: function () {
        window.location.href = 'shopSearch.html';
    },
    systemPage: function () {
        window.location.href = 'configView.html';
    },
    loadLogo: function (comp, eOpts) {
        comp.setSrc('img/logoshow.ico');
    },
    loadSystemTitle: function (comp, eOpts) {
        comp.setText('Admin');
    }
});