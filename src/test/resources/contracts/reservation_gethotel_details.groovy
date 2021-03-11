import org.springframework.cloud.contract.spec.Contract
Contract.make{
	request{
		method 'GET'
		urlPath('/hotels/api/v1/hotelDetails/2')
		headers {
			contentType(applicationJson())
		}
	}
	response{
		status OK()
		body(
				"hotel_Id":1,
				"name":"AMB",
				"description":"near ASP",
				"rating":"4.5",
				"phoneNumber":"123",
				"room":["room_id":1,
					"room_number":1,
					"room_rate":1,
					"room_availability":"Y",
					"type":"D"],
				"address":["id":1,
					"country":"IN",
					"state":"AP",
					"city":"VZM",
					"area":"BRP",
					"pincode":"123"]
				)
		headers {
			contentType(applicationJson())
		}
	}
}