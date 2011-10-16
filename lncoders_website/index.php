<?php 
  require_once 'inc/functions.php';
  if (array_key_exists('jnavigate', $_GET) || 
      array_key_exists('jnavigate', $_POST)) {
    load_partial();
  } else { 
?>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />

  <title>lncoders</title>
  <link href='http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:extralight,light,regular,bold' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" media="screen" type="text/css" href="style/style.css">
</head>

<body>
 
  <div id="wrap">
   
      
    <header>
      <img src="dunno.png" alt="Amazing logo" name="Insert_logo" width= 50% height="209" id="Insert_logo" style="" /></a> 

    </header>

    <nav id="main-nav">
      <ol>
        <li><a class="ext-trigger" href="index.php?page=home"> Home</a></li>
        <li><a class="ext-trigger" href="index.php?page=about"> About</a></li>
      </ol>
    </nav>
    
    <div id="main">
      <?php load_partial(); ?>
    </div>
    
    <footer>
    
    </footer>
    
  </div>

  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
  <script src="js/jnavigate.jquery.js"></script>
  <script>
    $(function () {
      $("#main").jNavigate({
          extTrigger: ".ext-trigger",
          intTrigger: ".trigger",
          loaded: utilsDemos
      });
      $("#kill").click(function (ev) {
        ev.preventDefault();
        $("#main").jNavigate("destroy");
      });
      utilsDemos(); // just in case user landed on utils page!
    });
    
    function utilsDemos () {
      $("#loadingDemo").unbind().click(function (ev) {
        ev.preventDefault();
        var $box = $("#loadingBox")
          , $loading = $box.data("jnavigate-overlay");
        if (!$loading) {
          $box.jNavigate("overlay");
          $loading = $box.data("jnavigate-overlay");
          $(this).text("Remove loading overlay");
        } else if ($loading.is(":hidden")) {
          $(this).text("Remove loading overlay");
          $loading.fadeIn(250);
        } else {
          $(this).text("Add loading overlay");
          $loading.fadeOut(400);
        }
      });
      $("#navigateDemo").unbind().click(function (ev) {
        ev.preventDefault();
        $("#navigateBox").jNavigate("navigate", {
            url: this.href
          , useHistory: false
        });
      });
    }
  </script>
<?php include 'inc/footer.php'; } ?>
