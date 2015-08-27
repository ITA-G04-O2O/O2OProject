Ext.define('config.model.configModel', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    fields: [
        {
        	name: 'configName'
        },
        {
            name: 'configValue'
        },
        {
            name: 'configId'
        }
    ]
});