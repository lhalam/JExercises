var FileAPI = {
    debug: false
    , staticPath: '${basedir}/resources/js/uploader/'
    , postNameConcat: function (name, idx){
        return  name + (idx != null ? '['+ idx +']' : '');
    }
};
