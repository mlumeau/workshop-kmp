//
//  MainViewModel.swift
//  kosmos
//
//  Created by Robin Caroff on 13/08/2019.
//  Copyright © 2019 Maxime Lumeau. All rights reserved.
//

import Foundation
import kore

final class MainViewModel {
    
    let getApodUseCase: GetApod = GetApodImpl()
    
    func startLoadingData(completion: @escaping (APOD)->(), error: ()->()) {
        getApodUseCase.getApod(completion: completion, error: error)
    }
}
