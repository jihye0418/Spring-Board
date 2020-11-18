$( document ).ready( function() {
  $( window ).scroll( function() {
    if ( $( this ).scrollTop() > 100 ) {
      $( '.top' ).fadeIn();
    } else {
      $( '.top' ).fadeOut();
    }
  } );
  $( '.top' ).click( function() {
    $( 'html, body' ).animate( { scrollTop : 0 }, 400 );
    return false;
  } );


	$(".burger-menu").click(function () {
    $(this).toggleClass("menu-on");
  });

} );

	