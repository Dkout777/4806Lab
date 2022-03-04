$(document).ready(function() {
    $.ajax({
        url: "/NewAddressBookController"
    }).then(function(data) {
        $('.greeting-id').append(data.id);
        $('.greeting-content').append(data.content);
    });
});