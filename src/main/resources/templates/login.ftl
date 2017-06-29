<head>
<div class="container" ng-app="crudApp">
  <div class="row">
    <div class="col-md-12">
      <div class="page-header">
        <h1>{{ title }}</h1>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/app.css" rel="stylesheet"/>
        <link href="css/style.css" rel="stylesheet"/>
      </div>
    </div>
    
    
    
  </div>
  
  </head>
  <body>
  <div ui-view></div>
  <script src="js/lib/angular.min.js" ></script>
        <script src="js/lib/angular-ui-router.min.js" ></script>
        <script src="js/lib/localforage.min.js" ></script>
        <script src="js/lib/ngStorage.min.js"></script>
        
<script src="js/app/app.js"></script>
<script src="js/app/UserService.js"></script>
        <script src="js/app/UserController.js"></script>
        
<script src="js/app/LoginService.js"></script>
 <script type = "text/ng-template" id = "login">
    <div class="col-md-12">
      <h3>Login Page</h3>
      
      <form ng-submit="formSubmit()" class="form">
        <div class="col-md-4">
          <div class="form-group">
            <input type="text" class="form-control" ng-model="username" placeholder="username" required=""/>
          </div> 

          <div class="form-group">
            <input type="password" class="form-control" ng-model="password" placeholder="password" required=""/>
          </div>

          <div class="form-group">
            <button type="submit" class="btn btn-success">Login</button>
            <span class="text-danger">{{ error }}</span>
          </div>

        </div>
      </form>
    </div>
    </script>
 <script type="text/ng-template" id="home.html">
    <div class="col-md-12">
      <h3>Hello Admin, click 'yes' if you are admin else click no </h3>
    
      <a href="https://salescalculator.cfapps.io/SalesTransaction/#/">Yes</a>
     <br> <a ui-sref="login">No</a>
    </div>
  </script>
</div>
</body>