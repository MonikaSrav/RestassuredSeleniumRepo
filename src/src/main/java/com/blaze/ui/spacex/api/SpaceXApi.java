package src.main.java.com.blaze.ui.spacex.api;
import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.testng.Reporter;

import com.test.base.TestBase;
import com.test.util.TestInfo;	


	public class SpaceXApi extends TestBase{
		Logger log = Logger.getLogger(SpaceXApi.class);

		public TestInfo getMethod() {			
				
			headerPara = new LinkedHashMap<String, String>();
			headerPara.put("Content-Type", "application/json");
			headerPara.put("Accept", "application/json");
			request.headers(headerPara);
			TestInfo apiSpaceInfo = null;
			try {
				res=request.get(endPoint);
				Reporter.log("Response of API: "+res.asString(),true);
				Reporter.log("Response of status: "+res.statusCode(),true);
				
				String sflightnumber=res.jsonPath().getString("flight_number");
				String sflightname=res.jsonPath().getString("name");
				String sflightsuccess=res.jsonPath().getString("success");
				apiSpaceInfo= new TestInfo(sflightnumber,sflightname,sflightsuccess);//
				
				Reporter.log("Verify: flightNo "+sflightnumber,true);
				Reporter.log("Verify: flightName "+sflightname,true);
				Reporter.log("Verify: flightsuccess "+sflightsuccess,true);
			}catch(Exception e) {
				Reporter.log("Response of API caught: "+res.asString(),true);

			}
			return apiSpaceInfo;
		}

	}


