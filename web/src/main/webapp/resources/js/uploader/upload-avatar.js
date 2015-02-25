if (top != self) {
    top.location.replace(document.location);
    alert("For security reasons, framing is not allowed; click OK to remove the frames.")
}

jQuery(function ($) {
    $('#cropper-preview').on('click', '.js-upload', function () {
        $('#upload-avatar').fileapi('upload');
        $('#cropper-preview').fadeOut();
    });
    $('#upload-avatar').fileapi({
        url: '/web/user/profile/avatar/',
        accept: 'image/*',
        imageSize: { minWidth: 100, minHeight: 100 },
        imageTransform: {
            maxWidth: 100,
            maxHeight: 100
        },
        elements: {
            active: { show: '.js-upload', hide: '.js-browse' },
            preview: {
                el: '.js-preview',
                width: 96,
                height: 96
            },
            progress: '.js-progress'
        },

        onSelect: function (evt, ui) {
            var file = ui.all[0];

            if (file) {
                $('#cropper-preview').show();

                $('.js-img').cropper({
                    file: file,
                    bgColor: '#fff',
                    maxSize: [$('#cropper-preview').width() - 40, $(window).height() - 100],
                    minSize: [100, 100],
                    selection: '90%',
                    aspectRatio: 1,
                    onSelect: function (coords) {
                        $('#upload-avatar').fileapi('crop', file, coords);
                    }
                });
            }
        },

        onComplete: function (evt, xhr) {

            try {
                var result = FileAPI.parseJSON(xhr.xhr.responseText);
                $('#avatar-hidden').attr("value", result.image);
            } catch (er) {
                FileAPI.log('PARSE ERROR:', er.message);
            }

        }

    });

});