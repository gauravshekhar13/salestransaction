<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Sales Tax Calculator </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.user.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.name" id="uname" class="username form-control input-sm" placeholder="Enter customer name" />
	                        </div>
	                    </div>
	                </div>
	                
	                
	                	              <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="accessories">CD</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.accessories" id="accessories" class="form-control input-sm" />
	                        </div>
	                         
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="food">Chocolate</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.food" id="food" class="form-control input-sm" />
	                        </div>
	                         
	                    </div>
	                </div>
	
		                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="impfood">Imported Chocolate</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.impfood" id="impfood" class="form-control input-sm" />
	                        </div>
	                    </div>
	                </div>
		                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="medicine">Medicine</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.medicine" id="medicine" class="form-control input-sm" />
	                        </div>
	                         
	                    </div>
	                </div>
	
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="perfume">Perfume</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.perfume" id="perfume" class="form-control input-sm" />
	                        </div>
	                       
	                    </div>
	                </div>
	                
	                	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="impperfume">Imported Perfume</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.impperfume" id="impperfume" class="form-control input-sm" />
	                        </div>
	                       
	                    </div>
	                </div>
	                
	                     <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="book">Book</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.book" id="book" class="form-control input-sm"  />
	                        </div>
	                         
	                    </div>
            
               
	                </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Sales Transaction </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>NAME</th>
		                <th>CD</th>
		                <th>CHOCOLATE</th>
		                <th>IMPORTED CHOCOLATE</th>
		                <th>PERFUME</th>
		                <th>IMPORTED PERFUME</th>
		                <th>BOOK</th>
		                <th>MEDICINE</th>
		                <th>SALES TAX</th>
		                <th>TOTAL</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllUsers()">
		                <td>{{u.id}}</td>
		                <td>{{u.name}}</td>
		               	<td>{{u.accessories}}</td>
		                <td>{{u.food}}</td>
		                <td>{{u.impfood}}</td>
		                <td>{{u.perfume}}</td>
		                 <td>{{u.impperfume}}</td>
		                <td>{{u.book}}</td>
		                <td>{{u.medicine}}</td>
		                <td>{{u.totalTax}}</td>
		                <td>{{u.total}}</td>
		                <td><button type="button" ng-click="ctrl.editUser(u.id)" class="btn btn-success custom-width">Print</button></td>
		                <td><button type="button" ng-click="ctrl.removeUser(u.id)" class="btn btn-danger custom-width">Delete</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>