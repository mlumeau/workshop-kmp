//
//  GetApodImpl.swift
//  kosmos
//
//  Created by Robin Caroff on 13/08/2019.
//  Copyright © 2019 Maxime Lumeau. All rights reserved.
//

import Foundation
import kore

class GetApodImpl: GetApod {
    
    private var job: Kotlinx_coroutines_core_nativeJob?
    private let nasaAPI : NasaApi = NasaAPIRemote()
    
    func getApod(completion: @escaping (APOD)->(), error: (()->())?) {
        job = nasaAPI.getAPOD{ apod in
            completion(apod)
            
            return .init()
        }
    }
    
    //TODO Handle cancellation
}
