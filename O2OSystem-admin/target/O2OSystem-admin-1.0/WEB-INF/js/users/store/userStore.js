/**
 * Created by HUANGVI2 on 8/26/2015.
 */
var usersStore = Ext.create('Ext.data.Store', {
    model: 'Users',
    proxy: {
        type: 'ajax',
        url: 'http://localhost:8888/O2OSystem-admin/AdminService/users',
        reader: {
            type: 'json',
            root: 'users'
        }
    },
    autoLoad: true
});