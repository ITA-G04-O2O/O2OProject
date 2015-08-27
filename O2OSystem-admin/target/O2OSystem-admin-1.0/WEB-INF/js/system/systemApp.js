Ext.Loader.setConfig({
    enabled: true
});

Ext.application({
    models: [
        'configModel'
    ],
    stores: [
        'categoryStore'
    ],
    views: [
        'systemView'
    ],
    controllers: [
        'searchController'
    ],
    name: 'system',
    appFolder: 'js/system',

    launch: function () {
        Ext.create('systemView');
    }

});
